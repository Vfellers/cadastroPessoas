

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Person> students = new ArrayList<Person>();

    public static void main(String[] args) {

        boolean exit = true;
        while (exit) {
            System.out.println("Seleciona a opção");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Buscar");
            System.out.println("3 - Remover");
            System.out.println("4 - Editar");
            System.out.println("5 - Sair");
            int option = scanner.nextInt();
            switch (option) {

                case 1:
                    addStudent(students);
                    break;

                case 2:
                    System.out.println("Qual o nome que deseja buscar?");
                    String nameToFind = scanner.next();
                    findStudent(students, nameToFind);
                    break;

                case 3:
                    removeStudent();
                    break;

                case 4:
                    editStudent();
                    break;

                case 5:
                    exit = false;
                    break;
            }
        }
    }

    private static void addStudent(List<Person> students) {
        Person student = new Person();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do estudante");
        student.name = scanner.next();
        students.add(student);
        System.out.println(student.name + "Cadastrado.");
    }

    private static Integer findStudent(List<Person> students, String studentName) {
        Integer position = null;
        for (int count = 0; count < students.size(); count++) {
            Person student = students.get(count);
            if (student.name.equals(studentName)) {
                position = count;
                System.out.println("Encontrei o " + studentName);
            }
        }
        return position;
    }

    private static void removeStudent() {
        System.out.println("Qual nome que deseja remover?");
        String name = scanner.next();
        Integer position = findStudent(students, name);
        if (position != null) {
            students.remove(position.intValue());
        }
    }

    private static void editStudent() {
        System.out.println("Qual nome deseja editar?");
        String name = scanner.next();
        Integer position = findStudent(students, name);
        if (position != null) {
            Person p1 = students.get(position.intValue());
            System.out.println("Qual o novo nome?");
            name = scanner.next();
            p1.name = name;
        }
    }
}



