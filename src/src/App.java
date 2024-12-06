import controller.RoleController;
import utils.DbConnection;

public class App {

    public static void main(String[] args) throws Exception {
        // DbConnection connection = new DbConnection();
        // connection.getConnection();

        RoleController roleController = new RoleController();
        roleController.get();
    }
}
