package education.java.Univursity.laba5;

import java.util.*;

class Tree { //Структура дерева из проекта "Двоичные деревья", измененная для целей задания
	Node root; // Единственное поле данных

	public Node find(char key) // Поиск узла с заданным ключом
	{ // (предполагается, что дерево не пустое)
		Node current = root; // Начать с корневого узла
		while (current.value != key) // Пока не найдено совпадение
		{
			if (key < current.iData) // Двигаться налево?
				current = current.leftChild;
			else
				current = current.rightChild; // Или направо?
			if (current == null) // Если потомка нет,
				return null; // поиск завершился неудачей
		}
		return current; // Элемент найден
	}

	public void insert(int id, char dd) {
		Node newNode = new Node(id, dd); // Создание нового узла
		if (root == null) {
			root = newNode;
		} // Корневой узел не существует
		else // Корневой узел занят
		{
			Node current = root; // Начать с корневого узла
			Node parent;
			while (true) // (Внутренний выход из цикла)
			{
				parent = current;
				if (id < current.iData) // Двигаться налево?
				{
					current = current.leftChild;
					if (current == null) // Если достигнут конец цепочки
					{ // вставить слева
						parent.leftChild = newNode;
						return;
					}
				} else // Или направо?
				{
					current = current.rightChild;
					if (current == null) // Если достигнут конец цепочки,
					{ // вставить справа
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public String Decode(String input) {
		String result = "";
		Node current = root;
		for(int i = 0; i < input.length(); i++) {
			char next = input.charAt(i);
			if(next == '0')
				current = current.leftChild;
			else
				current = current.rightChild;
			if(current.isTrail) {
				result += current.value;
				current = root;
			}
		}
		return result;
	}

	private void inOrder(Node localRoot, int currentDepth, String currentCode, HashMap<Character, String> codeTable) {
		if (localRoot != null) {
			String left = currentCode + "0"; // 0 в левой ветви
			if(localRoot.leftChild != null && !localRoot.leftChild.isTrail) localRoot.leftChild.value = '0';
 			inOrder(localRoot.leftChild, currentDepth + 1, left, codeTable);
			if(localRoot.isTrail) { //выводим код и символ только у листов 
				System.out.println("  ".repeat(currentDepth) + "[" + (localRoot.value == '\n' ? "<Line Break>" : localRoot.value) + "]" + "(" + currentCode + ")");
				codeTable.put(localRoot.value, currentCode);
			}
			else
				System.out.println("  ".repeat(currentDepth) + localRoot.value);
			String right = currentCode + "1"; // 1 в правой ветви
			if(localRoot.rightChild != null && !localRoot.rightChild.isTrail) localRoot.rightChild.value = '1';
			inOrder(localRoot.rightChild, currentDepth + 1, right, codeTable);
		}
	}

	public void printTree(HashMap<Character, String> codeTable) { // вывод дерева Хаффмана
		root.value = 'x';
		inOrder(root, 0, "", codeTable);
	}

	public Node minimum() // Возвращает узел с минимальным ключом
	{
		Node current, last = null;
		current = root; // Обход начинается с корневого узла
		while (current != null) // и продолжается до низа
		{
			last = current; // Сохранение узла
			current = current.leftChild; // Переход к левому потомку
		}
		return last;
	}

	public boolean delete(int key) // Удаление узла с заданным ключом
	{ // (предполагается, что дерево не пусто)
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		while (current.iData != key) // Поиск узла
		{
			parent = current;
			if (key < current.iData) // Двигаться налево?
			{
				isLeftChild = true;
				current = current.leftChild;
			} else // Или направо?
			{
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) // Конец цепочки
				return false; // Узел не найден
		}
		// Удаляемый узел найден
		// Если узел не имеет потомков, он просто удаляется.
		// Это первый случай
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root) // Если узел является корневым,
				root = null; // дерево очищается
			else if (isLeftChild)
				parent.leftChild = null; // Узел отсоединяется
			else // от родителя
				parent.rightChild = null;
		}
		// Продолжение delete()...

		// Случай 2
		// Продолжение delete()...
		// Если нет правого потомка, узел заменяется левым поддеревом
		else if (current.rightChild == null)
			if (current == root)
				root = current.leftChild;
			else if (isLeftChild) // Левый потомок родителя
				parent.leftChild = current.leftChild;
			else // Правый потомок родителя
				parent.rightChild = current.leftChild;
		// Если нет левого потомка, узел заменяется правым поддеревом
		else if (current.leftChild == null)
			if (current == root)
				root = current.rightChild;
			else if (isLeftChild) // Левый потомок родителя
				parent.leftChild = current.rightChild;
			else // Правый потомок родителя
				parent.rightChild = current.rightChild;
		// Случай 3
		// --------------------
		else // Два потомка, узел заменяется преемником
		{
			// Поиск преемника для удаляемого узла (current)
			Node successor = getSuccessor(current);
			// Родитель current связывается с посредником
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			// Преемник связывается с левым потомком current
			successor.leftChild = current.leftChild;
		} // Конец else для двух потомков
			// (преемник не может иметь левого потомка)
		return true;

	}

	// Метод возвращает узел со следующим значением после delNode.
	// Для этого он сначала переходит к правому потомку, а затем
	// отслеживает цепочку левых потомков этого узла.
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild; // Переход к правому потомку
		while (current != null) // Пока остаются левые потомки
		{
			successorParent = successor;
			successor = current;
			current = current.leftChild; // Переход к левому потомку
		}
		// Если преемник не является
		if (successor != delNode.rightChild) // правым потомком,
		{ // создать связи между узлами
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
}
