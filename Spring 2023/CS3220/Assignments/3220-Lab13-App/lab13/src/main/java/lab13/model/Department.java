package lab13.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
	
	private static int idSeed;
	
	private int departmentId;

    private String name;

    private List<Faculty> faculty;

    public Department()
    {
    	this.departmentId = idSeed++;
        faculty = new ArrayList<Faculty>();
    }

    public Department( String name )
    {
        this();
        this.name = name;
    }

    public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public List<Faculty> getFaculty()
    {
        return faculty;
    }

    public void setFaculty( List<Faculty> faculty )
    {
        this.faculty = faculty;
    }

}