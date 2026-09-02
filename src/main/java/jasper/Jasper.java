package jasper;

import jasper.command.Command;
import jasper.parser.Parser;
import jasper.storage.Storage;
import jasper.task.TaskList;

public class Jasper {
    private final Storage storage;
    private final TaskList tasks;
    private String commandType;

    public Jasper(String parent, String filename) {
        storage = new Storage(parent, filename);
        TaskList tmp;
        try {
            tmp = new TaskList(storage.load());
        } catch (JasperException e) {
            tmp = new TaskList();
        }
        tasks = tmp;
    }

    public static void main(String[] args) {
        System.out.println("Hello!");
    }

    public String getResponse(String input) {
        try {
            Command c = Parser.parseCmd(input);
            commandType = c.getClass().getSimpleName();
            String response = c.execute(tasks);
            storage.save(tasks);
            return response;
        } catch (JasperException e) {
            commandType = "Error";
            return "Error: " + e.getMessage();
        }
    }

    public String getCommandType() {
        return commandType;
    }
}
