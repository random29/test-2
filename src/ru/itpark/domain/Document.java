package ru.itpark.domain;

public class Document {
    private int id;
    private String name;
    private String minPermission;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMinPermission() {
        return minPermission;
    }

    public void setMinPermission(String minPermission) {
        this.minPermission = minPermission;
    }

    public Document(int id, String name, String minPermission) {
        this.id = id;
        this.name = name;
        this.minPermission = minPermission;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minPermission='" + minPermission + '\'' +
                '}';
    }
}
