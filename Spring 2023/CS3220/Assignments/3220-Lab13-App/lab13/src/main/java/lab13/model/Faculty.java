package lab13.model;

public class Faculty {
	
	private static int idSeed;
	
	private int facultyId;

    private String name;

    private boolean isChair;

    public Faculty()
    {
    	this.facultyId = idSeed++;
        isChair = false;
    }

    public Faculty( String name )
    {
        this();
        this.name = name;
    }

    public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public boolean isChair()
    {
        return isChair;
    }

    public void setChair( boolean isChair )
    {
        this.isChair = isChair;
    }
}
