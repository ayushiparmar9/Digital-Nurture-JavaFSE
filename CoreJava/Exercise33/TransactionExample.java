import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionExample {

    public static void transfer(
            int fromId,
            int toId,
            double amount
    ) {

        String url =
                "jdbc:mysql://localhost:3306/college";

        try {

            Connection conn =
                    DriverManager.getConnection(
                            url,
                            "root",
                            "root"
                    );

            conn.setAutoCommit(false);

            PreparedStatement debit =
                    conn.prepareStatement(

                            "UPDATE accounts SET balance=balance-? WHERE id=?"
                    );

            debit.setDouble(1,amount);
            debit.setInt(2,fromId);

            debit.executeUpdate();

            PreparedStatement credit =
                    conn.prepareStatement(

                            "UPDATE accounts SET balance=balance+? WHERE id=?"
                    );

            credit.setDouble(1,amount);
            credit.setInt(2,toId);

            credit.executeUpdate();

            conn.commit();

            System.out.println(
                    "Transfer Successful"
            );

            conn.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        transfer(
                1,
                2,
                1000
        );
    }
}import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionExample {

    public static void transfer(
            int fromId,
            int toId,
            double amount
    ) {

        String url =
                "jdbc:mysql://localhost:3306/college";

        try {

            Connection conn =
                    DriverManager.getConnection(
                            url,
                            "root",
                            "root"
                    );

            conn.setAutoCommit(false);

            PreparedStatement debit =
                    conn.prepareStatement(

                            "UPDATE accounts SET balance=balance-? WHERE id=?"
                    );

            debit.setDouble(1,amount);
            debit.setInt(2,fromId);

            debit.executeUpdate();

            PreparedStatement credit =
                    conn.prepareStatement(

                            "UPDATE accounts SET balance=balance+? WHERE id=?"
                    );

            credit.setDouble(1,amount);
            credit.setInt(2,toId);

            credit.executeUpdate();

            conn.commit();

            System.out.println(
                    "Transfer Successful"
            );

            conn.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        transfer(
                1,
                2,
                1000
        );
    }
}