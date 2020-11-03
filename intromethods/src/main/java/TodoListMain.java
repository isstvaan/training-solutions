import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TodoListMain {

    public static void main(String[] args) {
        TodoList todoList = new TodoList();

        for (int i = 0; i < 100; i++) {
            todoList.addTodo("Todo " + i);
        }

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            if (random.nextInt(11) > 5) {
                todoList.finishTodo("Todo " + i);
                System.out.println("Todo " + i);
            }
        }

        System.out.println(todoList.numberOfFinishedTodos());
        System.out.println(todoList.todosToFinish().toString());

        List<Todo> tmp = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (random.nextInt(11) > 5) {
                tmp.add(new Todo("Todo " + i));
            }
        }
        todoList.finishAllTodos(tmp);

        System.out.println(todoList.numberOfFinishedTodos());
        System.out.println(todoList.todosToFinish().toString());

        System.out.println(todoList.toString() );

    }
}
