package binarytree;

public class BinaryTree {
    // Создаем класс Node, со следующими параметрами:
    private class Node {
        int value; // значение, которое мы храним в нашем узле
        Node leftChild; // левый ребенок
        Node rightChild; // правый ребенок

        Node(int value) {
            this.value = value;
            rightChild = null;
            leftChild = null;
        }
        // Переопределяем метод toString
        @Override
        public String toString() {
            return "Node{"+
                    "value=" + value +
                    '}';
        }
    }

    // Создаем начальный узел дерева - root
    private Node root;

    // Создаем приватный метод, который будет искать место, куда добавить новый узел.
    // При этом сохраняем сортировку дерева.
    private Node addNode(Node node, int value) {
        // Если текущий узнел равен null, значит мы нашли место, куда можно вставить ноду
        if (node == null) {
            return new Node(value);
        }
        // Если значение меньше значения текущего узла, рекурсивно ищем место для нашей ноды слева
        if (value < node.value) {
            node.leftChild = addNode(node.leftChild, value);
        // Если значение больше значения текущего узла, рекурсивно ищем место для нашей ноды справа
        } else if (value > node.value) {
            node.rightChild = addNode(node.rightChild, value);
        }
        // Если значение равно текущему значению узла, создать новую ноду нельзы,
        // так как бинарное дерево содержит только уникальные элементы
        else {
            return node;
        }
        return node;
    }
        // Создаем метод добавления новой ноды, который запускает рекурсию, начиная с корня
        public void add(int value) {
        root = addNode(root, value);
    }

    // Создаем приватную функцию, которая проверит, есть ли нода с определенным значением внутри.
    // node - ссылка на ноду, value - значение,которое будем проверять
    // Рекурсивным способом перебираем значения(в зависимости от того, больше или меньше значение текущей ноды,
    // проверяем справа или слева).
    // Если значание не находится, возвращаем false
    // Если значение найдено, возвращаем true
    private boolean containsNodeOrNot(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.value) {
            return true;
        }
        return value < node.value
                ? containsNodeOrNot(node.leftChild, value)
                : containsNodeOrNot(node.rightChild, value);
    }
    // Создадим публичный метод для поиска элемента, начиная с корневого
    public boolean containsNode(int value) {
        return containsNodeOrNot(root, value);
    }

    // Создадим метод для удаления элемента.
    // Сначала нужно проверить, есть ли в дереве нода с определенным значением внутри
    // node - ссылка на ноду, value - значение,которое будем проверять
    // Рекурсивным способом перебираем значения.
    private Node deleteNode(Node node, int value){
        if (node == null) {
            return null;
        }
        if (value == node.value) {
            // Нода для удаления найдена. Здесь и проводим удаление ноды
            // Если у ноды нет детей, то заменяем этот узел на null
            if (node.leftChild == null && node.rightChild == null) {
                return null;
            }
            // Если один ребенок, то заменяем ноду на ребенка
            if (node.rightChild == null) {
                return node.leftChild;
            }
            if (node.leftChild == null) {
                return node.rightChild;
            } else {
            // Если ребенка два, то необходимо балансировать дерево
            // Найдем узел, который заменит удаляемый узел
            // Присвоим наименьшее значение удаляемому узлу и удалим его из правого поддерева
                int smallest = smallestValue(node.rightChild);
                node.value = smallest;
                node.rightChild = deleteNode(node.rightChild, smallest);
                return node;
            }
        }
        if (value < node.value) {
            node.leftChild=deleteNode(node.leftChild,value);
        } else {
            node.rightChild = deleteNode(node.rightChild, value);
        }
        return node;
    }
    // Создаем метод для поиска наименьшего узла правого поддерева узла,
    // который будет потом удален
    private int smallestValue(Node root) {
        return root.leftChild == null ? root.value : smallestValue(root.leftChild);
    }

    // Создадим публичный метод, который запустит удаление с корня
    public void delete(int value) {
        root = deleteNode(root, value);
    }
}