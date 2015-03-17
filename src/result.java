class result{
     
    private String fileName;
    private int count;
     
    public result(String n, int s){
        this.fileName = n;
        this.count = s;
    }
     
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String name) {
        this.fileName = name;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public String toString(){
        return "Name: "+this.fileName+"-- Salary: "+this.count;
    }
}
