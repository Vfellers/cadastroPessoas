

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Person> students = new ArrayList<Person>();

    public static void main(String[] args) {

        boolean exit = true;
        while (exit) {
            System.out.println("Selecione a opção");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Buscar");
            System.out.println("3 - Remover");
            System.out.println("4 - Editar");
            System.out.println("5 - Listar");
            System.out.println("6 - Sexo");
            System.out.println("7 - Sair");
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
                    listStudent();
                    break;

                case 6:
                    studentSex();
                    break;

                case 7:
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
        System.out.println("Digite o sexo do estudante");
        student.sex = scanner.next().toUpperCase();
        System.out.println("Digite a idade do estudante");
        student.age = scanner.nextInt();
        System.out.println(student.name + "Cadastrado.");
    }

    private static Integer findStudent(List<Person> students, String studentName) {
        Integer position = null;
        for (int count = 0; count < students.size(); count++) {
            Person student = students.get(count);
            if (student.name.equals(studentName)) {
                position = count;
                System.out.println("Nome: " + studentName + " - Idade: " + student.age + " - Sexo: " + student.sex);
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

    private static void listStudent() {

        System.out.println("\nAlunos Cadastrados:");
        for(int count = 0; count < students.size(); count++) {
            Person student = students.get(count);
            System.out.println("Nome: " + student.name + " - Idade: " + student.age + " - Sexo: " + student.sex);
        }
    }

    private static void studentSex() {

        var masculino = 0;
        var feminino = 0;

        for(int count = 0; count < students.size(); count++) {
            Person student = students.get(count);
            if (student.sex.equals("M")){
                masculino++;
            } else if (student.sex.equals("F")){
                feminino++;
            }
        }
        System.out.println("Total masculino: " + masculino + "\nTotal feminino: " + feminino + "\n");

    }

}



