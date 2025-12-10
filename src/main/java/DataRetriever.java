import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

   private DBConnection dbConnection;
    public DataRetriever() {
        this.dbConnection = new DBConnection();
    }

    public DataRetriever(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public List<Category> getAllCategories() throws SQLException {
        List<Category> categories = new ArrayList<>();

        String query = "SELECT id, name FROM product_category ORDER BY id DESC";

        try(Connection connection = dbConnection.getDBConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                   Category category = new Category(resultSet.getInt("id"), resultSet.getString("name"));

                   categories.add(category);
                }
                resultSet.close();
                statement.close();
                connection.close();
                return categories;

        } catch (SQLException e)  {
            e.printStackTrace();
            throw new SQLException("Failed to retrieve categories", e);
        }

    }


    List<Product> getProductList(int page, int size) throws SQLException {
        List<Product> product = new ArrayList<>();
      String query = "SELECT p.id, p.name, p.price, p.creation_datetime, pc.name as category_name " +
                      "FROM product p " +
                      "LEFT JOIN product_category pc ON p.category_id = pc.id " +
                      "ORDER BY p.id " +
                      "LIMIT ? OFFSET ?";


        try(Connection connection = dbConnection.getDBConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Product product1 = new Product(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getDate("creationDateTime"), resultSet."category"))
            }
        })
    }
    }



