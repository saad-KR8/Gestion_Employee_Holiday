package Model;

public class Holiday {
    private int id;
    private int idEmployee;
    private T_Holiday type;
    private String start;
    private String end;
    public Holiday(int id, int idEmployee, T_Holiday type, String start, String end) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.type = type;
        this.start = start;
        this.end = end;
    }
    public Holiday() {
        this.id = 0;
        this.idEmployee = 0;
        this.type = null;
        this.start = null;
        this.end = null;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public T_Holiday getType() {
        return type;
    }

    public void setType(T_Holiday type) {
        this.type = type;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
