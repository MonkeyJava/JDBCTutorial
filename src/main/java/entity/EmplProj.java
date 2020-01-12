package entity;

public class EmplProj {

    private int employeeId;
    private int projectId;

    public EmplProj(){}

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmplProj emplProj = (EmplProj) o;

        if (employeeId != emplProj.employeeId) return false;
        return projectId == emplProj.projectId;

    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + projectId;
        return result;
    }

    @Override
    public String toString() {
        return "EmplProj{" +
                "employeeId=" + employeeId +
                ", projectId=" + projectId +
                '}';
    }
}
