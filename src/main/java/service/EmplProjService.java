package service;

import bl.Util;
import dao.EmplProjDAO;
import entity.EmplProj;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmplProjService extends Util implements EmplProjDAO {
    Connection connection = getConnection();

    @Override
    public void add(EmplProj emplProj) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO EMPL_PROJ (EMPLOYEE_ID, PROJECT_ID) VALUES (?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, emplProj.getEmployeeId());
            preparedStatement.setInt(2, emplProj.getProjectId());
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }

    @Override
    public List<EmplProj> getAll() throws SQLException {
        List<EmplProj> emplProjList = new ArrayList<>();
        Statement statement = null;
        String sql = "SELECT EMPLOYEE_ID, PROJECT_ID FROM EMPL_PROJ";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                EmplProj emplProj = new EmplProj();
                emplProj.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
                emplProj.setProjectId(resultSet.getInt("PROJECT_ID"));
                emplProjList.add(emplProj);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
        return emplProjList;
    }

    @Override
    public EmplProj getByEmpployeeIdAndProjectId(int employeeId, int projectId) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT EMPLOYEE_ID, PROJECT_ID FROM EMPL_PROJ WHERE EMPLOYEE_ID=? AND PROJECT_ID=?";
        EmplProj emplProj = new EmplProj();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employeeId);
            preparedStatement.setInt(2, projectId);
           ResultSet resultSet = preparedStatement.executeQuery();
           resultSet.next();
           emplProj.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
           emplProj.setProjectId(resultSet.getInt("PROJECT_ID"));
         //  preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return emplProj;
    }

    @Override
    public void update(EmplProj emplProj) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE EMPL_PROJ SET EMPLOYEE_ID=?, PROJECT_ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, emplProj.getEmployeeId());
            preparedStatement.setInt(2, emplProj.getProjectId());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }

    }

    @Override
    public void remove(EmplProj emplProj) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM EMPL_PROJ WHERE EMPLOYEE_ID=? AND PROJECT_ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, emplProj.getEmployeeId());
            preparedStatement.setInt(2, emplProj.getProjectId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }

    }
}
