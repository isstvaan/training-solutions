package intromethods;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Todo> todos = new ArrayList<>();

    public void addTodo(String caption) {
        todos.add(new Todo(caption));
    }

    public void finishTodo(String caption) {
        for (Todo item : todos) {
            if (item.getCaption().equals(caption)) {
                item.finish();
            }
        }
    }

    public void finishAllTodos(List<Todo> todo) {
        for (Todo item1 : todo) {
            for (Todo item2 : todos) {
                if (item1.getCaption().equals(item2.getCaption())) {
                    item2.finish();
                }
            }
        }
    }

    public List<Todo> todosToFinish() {
        List<Todo> retVal = new ArrayList<>();
        for (Todo item : todos) {
            if (!item.isFinished()) {
                retVal.add(item);
            }
        }
        return retVal;
    }

    public int numberOfFinishedTodos() {
        int counter = 0;
        for (Todo item : todos) {
            if (item.isFinished()) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "todos=" + todos.toString() +
                '}';
    }
}
