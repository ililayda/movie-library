package de.netempire.movie_library.garbage;

public class Garbage {


//    String SQLCommand = "SELECT * FROM `actor` WHERE id in (SELECT actor_id FROM actor_in_movie WHERE movie_id in (SELECT id FROM movie WHERE title = ? ));";
//        Connection conn = null;
//
//        try {
//
//            conn = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPassword());
//            Statement stmt = conn.createStatement();
//            stmt.execute("USE " + this.getDb());
//
//
//            if (conn != null) {
//                System.out.println("Connected to the Database! ");
//
//                PreparedStatement preparedStatement = conn.prepareStatement(SQLCommand);
//                preparedStatement.setString(1, name);
//                ResultSet rs = preparedStatement.executeQuery();
//
//                while (rs.next()) {
//                    return actorRepository.findAll();
//                }
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        } finally {
//            if (conn != null)
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//
//                }
//        }

}
