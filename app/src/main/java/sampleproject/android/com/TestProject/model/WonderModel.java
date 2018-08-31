package sampleproject.android.com.TestProject.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class WonderModel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private WonderModelData[] data;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public WonderModelData[] getData() {
        return this.data;
    }

    public void setData(WonderModelData[] data) {
        this.data = data;
    }
}
