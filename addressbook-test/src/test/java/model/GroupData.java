package model;

import java.util.Objects;

public class GroupData {
    private String name;
    private String header;
    private String footer;



    public GroupData wihtName(String name) {
        this.name = name;
        return this;
    }

    public GroupData wihtHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupData wihtFooter(String footer) {
        this.footer = footer;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(name, groupData.name) &&
                Objects.equals(header, groupData.header) &&
                Objects.equals(footer, groupData.footer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, header, footer);
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "name='" + name + '\'' +
                ", header='" + header + '\'' +
                ", footer='" + footer + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }
}
