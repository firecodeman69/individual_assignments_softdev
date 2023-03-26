public class Item {
    private String name;
    private String description;

    public Item (String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

//    public String Inspect() {
//        return this.description;
//    }

//    public void setDescription(String description) {
//        this.description = description;
//    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return (this.name + ": " + description);
    }


}
