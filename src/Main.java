void main() {
    MiListaCircular lista = new MiListaCircular();
    System.out.println(lista.toString());
    System.out.println("¿Está vacía? " + lista.isEmpty());

    lista.insertHead(0);
    lista.insertHead("Juan");
    lista.insertHead(true);
    lista.insertTail("Angela");

    System.out.println(lista.toString());
    System.out.println("Tamaño: " + lista.getSize());
    System.out.println("Cabeza: " + lista.getHead());
    System.out.println("Cola: " + lista.getTail());

    Node nodoJuan = lista.search("Juan");
    System.out.println("¿Contiene 'Juan'? " + lista.contains("Juan"));
    System.out.println("Dato del nodo encontrado: " + lista.get(nodoJuan));

    lista.set(nodoJuan, "Juan Carlos");
    System.out.println("Después de set: " + lista.toString());

    lista.insert(nodoJuan, "Nuevo después de Juan Carlos");
    System.out.println("Después de insert(node, object): " + lista.toString());

    lista.insert("Angela", "Nuevo después de Angela");
    System.out.println("Después de insert(objectRef, object): " + lista.toString());

    Object[] arreglo = lista.toArray();
    System.out.print("Arreglo: ");
    for (Object o : arreglo) {
        System.out.print(o + " ");
    }
    System.out.println();

    lista.remove(nodoJuan);
    System.out.println("Después de remove: " + lista.toString());

    lista.add("Elemento agregado con add()");
    System.out.println("Después de add: " + lista.toString());

    lista.clear();
    System.out.println("Después de clear: " + lista.toString());
    System.out.println("¿Está vacía? " + lista.isEmpty());


    MiListaCircular numeros = new MiListaCircular();
    numeros.insertTail(5);
    numeros.insertTail(1);
    numeros.insertTail(3);
    numeros.insertTail(2);
    numeros.insertTail(4);
    System.out.println("Lista de números: " + numeros.toString());

    MiListaCircular ordenada = numeros.sortList();
    System.out.println("Lista ordenada: " + ordenada.toString());

    Node inicio = numeros.search(1);
    Node fin = numeros.search(2);
    MiListaCircular sub = numeros.subList(inicio, fin);
    System.out.println("Sublista de 1 a 2: " + sub.toString());
}