package UI;

import Config.JDBConnect;
import Services.WorksServices;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StartProject {

    public void startProgram() throws SQLException, IOException, URISyntaxException {

        int number;

        JDBConnect jdbConnect = new JDBConnect();
        jdbConnect.createTable();
        WorksServices worksServices = new WorksServices();

        Scanner in = new Scanner(System.in);

        while (true) {

            System.out.println("Если вы желаете просмотреть информацию о всех работах - введите 1\n" +
                    "Если Вы желаете посмотреть кто является заказчиком - введите 2\n" +
                    "Если Вы желаете посмотреть информацию о бригаде - введите 3\n" +
                    "Если Вы желаете создать работу - введите 4\n" +
                    "Поиск записи по Id - введите 5\n" +
                    "Удаление записи по Id - введите 6\n" +
                    "Выйти - введите 7\n" +
                    "Введите что Вы желаете сделать: ");

            do {
                while (!in.hasNextInt()) {
                    System.out.println("Введите число");
                    in.next();
                }

                number = in.nextInt();

            } while (number <= 0);

            switch (number) {
                case 1: {
                    ResultSet resultSet = JDBConnect.statement.executeQuery("select * from works");
                    while (resultSet.next()) {
                        System.out.println("id: " + resultSet.getInt("works_id"));
                        System.out.println("type: " + resultSet.getString("type"));
                        System.out.println("size: " + resultSet.getString("size"));
                        System.out.println("prefercompletedate: " + resultSet.getString("prefercompletedate"));
                    }
                    break;
                }
                case 2: {
                    ResultSet resultSet = JDBConnect.statement.executeQuery("select * from reported");
                    while (resultSet.next()) {
                        System.out.println("id: " + resultSet.getInt("reported_id"));
                        System.out.println("name: " + resultSet.getString("name"));
                    }
                    break;
                }
                case 3: {
                    ResultSet resultSet = JDBConnect.statement.executeQuery("select * from members");
                    while (resultSet.next()) {
                        System.out.println("id: " + resultSet.getInt("members_id"));
                        System.out.println("members: " + resultSet.getString("name"));
                    }
                    break;
                }
                case 4: {
                    worksServices.createWorks();
                    worksServices.createReported();
                    worksServices.createMembers();
                    break;
                }
                case 5: {
                    System.out.println("1 - поиск работы по Id\n" +
                            "2 - поиск заказчика по Id\n" +
                            "3 - поиск команды по Id\n" +
                            "Выберите кого Вы желаете найти: ");
                    Scanner find = new Scanner(System.in);
                    do {
                        while (!find.hasNextInt()) {
                            System.out.println("Введите число");
                            find.next();
                        }

                        number = find.nextInt();

                    } while (number <= 0);
                    switch (number){
                        case 1:{
                            Scanner findById = new Scanner(System.in);
                            System.out.println("Введите id работы, информацию о которой вы желаете получить: ");
                            do {
                                while (!findById.hasNextInt()) {
                                    System.out.println("Введите число");
                                    findById.next();
                                }

                                number = findById.nextInt();

                            } while (number <= 0);
                            worksServices.findByIdWorks(number);
                            break;
                        }
                        case 2:{
                            Scanner findById = new Scanner(System.in);
                            System.out.println("Введите id работы, информацию о которой вы желаете получить: ");
                            do {
                                while (!findById.hasNextInt()) {
                                    System.out.println("Введите число");
                                    findById.next();
                                }

                                number = findById.nextInt();

                            } while (number <= 0);
                            worksServices.findByIdReported(number);
                            break;
                        }
                        case 3:{
                            Scanner findById = new Scanner(System.in);
                            System.out.println("Введите id работы, информацию о которой вы желаете получить: ");
                            do {
                                while (!findById.hasNextInt()) {
                                    System.out.println("Введите число");
                                    findById.next();
                                }

                                number = findById.nextInt();

                            } while (number <= 0);
                            worksServices.findByIdMembers(number);
                            break;
                        }
                    }
                    break;
                }
                case 6: {
                    System.out.println("1 - удалить работу по Id\n" +
                            "2 - удалить команду по Id\n" +
                            "Выберите кого вы желаете удалить: \"");
                    Scanner delete = new Scanner(System.in);
                    do {
                        while (!delete.hasNextInt()) {
                            System.out.println("Введите число");
                            delete.next();
                        }

                        number = delete.nextInt();

                    } while (number <= 0);


                    switch (number) {
                        case 1: {
                            Scanner deleteById = new Scanner(System.in);
                            System.out.println("Введите id работы, которую вы желаете удалить: ");
                            do {
                                while (!deleteById.hasNextInt()) {
                                    System.out.println("Введите число");
                                    deleteById.next();
                                }

                                number = deleteById.nextInt();

                            } while (number <= 0);
                            worksServices.deleteFromIdWork(number);
                            break;
                        }
                        case 2: {
                            Scanner deleteById = new Scanner(System.in);
                            System.out.println("Введите id команды, которую вы желаете удалить: ");
                            do {
                                while (!deleteById.hasNextInt()) {
                                    System.out.println("Введите число");
                                    deleteById.next();
                                }

                                number = deleteById.nextInt();

                            } while (number <= 0);
                            worksServices.deleteFromIdMembers(number);
                            break;
                        }
                    }
                    break;
                }
                case 7: {
                    System.exit(0);
                }

            }
        }
    }
}
