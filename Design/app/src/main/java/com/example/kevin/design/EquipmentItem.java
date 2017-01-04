package com.example.kevin.design;

/**
 * Created by Callum on 18/11/2016.
 */

public class EquipmentItem {
    private String individual;
    private String name;
    private String project;
    private String barcodeId;
    private String expiryDate;
    private boolean damaged;


    EquipmentItem(String name,String person, String proj, String barcodeContents, String expiry,boolean damaged){
        individual = person;
        project=proj;
        barcodeId = barcodeContents;
        expiryDate = expiry;
        this.name=name;
        this.damaged=damaged;
    }

    public String getData(){
        String data;
        data = "Barcode ID:" + this.barcodeId + " Item Owner: " + individual + " ProjectID: " + project + " Project End Date: " +
                expiryDate;
        return data;
    }

    public String getProjectID(){
        return project;
    }
    public String getName(){
        return name;
    }
    public String getExpiryDate(){return expiryDate;}
    public String getBarcodeID(){return barcodeId;}
    public String toString(){
        String s= "" + damaged;
        return "Barcode ID: " + this.barcodeId + "\n" +"Item Owner: " + individual + "\n"+
                "ProjectID: " + project +"\n"+ "Project End Date: " +
                expiryDate+ "\n"+ "Is damaged? " + (s.equals(true) ?"True":"False");
    }

    public String getIndividual() {
        return individual;
    }

    public boolean isDamaged() {
        return damaged;
    }
}



