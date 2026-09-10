public class MiListaCircular implements ListInterface {
    Node cabeza = null;

    @Override
    public boolean isEmpty() {
        return this.cabeza == null;
    }

    @Override
    public int getSize() {
        if (this.cabeza == null) {
            return 0;
        }
        Node iterador = this.cabeza;
        int contador = 1;
        while (iterador.siguiente != this.cabeza) {
            iterador = iterador.siguiente;
            contador++;
        }
        return contador;
    }

    @Override
    public void clear() {
        this.cabeza = null;
    }

    @Override
    public Object getHead() {
        if (this.cabeza == null) {
            return null;
        }
        return this.cabeza.dato;
    }

    @Override
    public Object getTail() {
        if (this.cabeza == null) {
            return null;
        }
        Node iterador = this.cabeza;
        while (iterador.siguiente != this.cabeza) {
            iterador = iterador.siguiente;
        }
        return iterador.dato;
    }

    @Override
    public Object get(Node node) {
        if (node == null) {
            return null;
        }
        return node.dato;
    }

    @Override
    public Node search(Object object) {
        if (this.cabeza == null) {
            return null;
        }
        Node iterador = this.cabeza;
        do {
            if (iterador.dato == null ? object == null : iterador.dato.equals(object)) {
                return iterador;
            }
            iterador = iterador.siguiente;
        } while (iterador != this.cabeza);
        return null;
    }

    @Override
    public boolean add(Object object) {
        return insertTail(object);
    }

    @Override
    public boolean insert(Node node, Object object) {
        try {
            if (node == null) {
                return insertHead(object);
            }
            Node nuevo = new Node(object);
            nuevo.siguiente = node.siguiente;
            node.siguiente = nuevo;
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean insert(Object objectRef, Object object) {
        try {
            Node nodoReferencia = search(objectRef);
            if (nodoReferencia == null) {
                return false;
            }
            return insert(nodoReferencia, object);
        } catch (Exception e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean insertHead(Object object) {
        try {
            Node nuevo = new Node(object);
            if (this.cabeza == null) {
                nuevo.siguiente = nuevo;
                this.cabeza = nuevo;
            } else {
                Node ultimo = this.cabeza;
                while (ultimo.siguiente != this.cabeza) {
                    ultimo = ultimo.siguiente;
                }
                nuevo.siguiente = this.cabeza;
                ultimo.siguiente = nuevo;
                this.cabeza = nuevo;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean insertTail(Object object) {
        try {
            Node nuevo = new Node(object);
            if (this.cabeza == null) {
                nuevo.siguiente = nuevo;
                this.cabeza = nuevo;
            } else {
                Node ultimo = this.cabeza;
                while (ultimo.siguiente != this.cabeza) {
                    ultimo = ultimo.siguiente;
                }
                ultimo.siguiente = nuevo;
                nuevo.siguiente = this.cabeza;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean set(Node node, Object object) {
        if (node == null) {
            return false;
        }
        node.dato = object;
        return true;
    }

    @Override
    public boolean remove(Node node) {
        if (node == null || this.cabeza == null) {
            return false;
        }
        Node anterior = this.cabeza;
        int tam = getSize();
        int vueltas = 0;
        while (anterior.siguiente != node && vueltas < tam) {
            anterior = anterior.siguiente;
            vueltas++;
        }
        if (anterior.siguiente != node) {
            return false;
        }
        anterior.siguiente = node.siguiente;
        if (node == this.cabeza) {
            this.cabeza = (node.siguiente == node) ? null : node.siguiente;
        }
        return true;
    }

    @Override
    public boolean contains(Object object) {
        return search(object) != null;
    }

    @Override
    public Object[] toArray() {
        if (this.cabeza == null) {
            return new Object[0];
        }
        Object[] arreglo = new Object[getSize()];
        Node iterador = this.cabeza;
        int i = 0;
        do {
            arreglo[i] = iterador.dato;
            i++;
            iterador = iterador.siguiente;
        } while (iterador != this.cabeza);
        return arreglo;
    }

    @Override
    public Object[] toArray(Object[] object) {
        if (this.cabeza == null) {
            return object;
        }
        int tam = getSize();
        Object[] arreglo = (object.length >= tam) ? object : new Object[tam];
        Node iterador = this.cabeza;
        int i = 0;
        do {
            arreglo[i] = iterador.dato;
            i++;
            iterador = iterador.siguiente;
        } while (iterador != this.cabeza);
        if (arreglo.length > tam) {
            arreglo[tam] = null;
        }
        return arreglo;
    }

    @Override
    public MiListaCircular subList(Node from, Node to) {
        if (from == null || to == null || this.cabeza == null) {
            return null;
        }
        MiListaCircular nueva = new MiListaCircular();
        Node iterador = from;
        int limite = getSize();
        int pasos = 0;
        boolean encontrado = false;
        while (pasos <= limite) {
            nueva.insertTail(iterador.dato);
            if (iterador == to) {
                encontrado = true;
                break;
            }
            iterador = iterador.siguiente;
            pasos++;
        }
        if (!encontrado) {
            return null;
        }
        return nueva;
    }

    @Override
    public MiListaCircular sortList() {
        Object[] arreglo = toArray();
        for (int i = 1; i < arreglo.length; i++) {
            Object actual = arreglo[i];
            int j = i - 1;
            while (j >= 0 && ((Comparable) arreglo[j]).compareTo(actual) > 0) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = actual;
        }
        MiListaCircular ordenada = new MiListaCircular();
        for (Object o : arreglo) {
            ordenada.insertTail(o);
        }
        return ordenada;
    }

    @Override
    public String toString() {
        if (this.cabeza == null) {
            return "MiListaCircular{}";
        }
        StringBuilder sb = new StringBuilder("MiListaCircular{");
        Node iterador = this.cabeza;
        do {
            sb.append(iterador.dato);
            iterador = iterador.siguiente;
            if (iterador != this.cabeza) {
                sb.append(", ");
            }
        } while (iterador != this.cabeza);
        sb.append("}");
        return sb.toString();
    }
}