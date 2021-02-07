/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hometastic;

/**
 *
 * @author user
 */
class Report {
    
    private int reportID;
    private String reportType;
    private String reportDesc;
    private String reportStatus;
    
    Report(int reportID, String reportType, String reportDesc, String reportStatus){
        this.reportID=reportID;
        this.reportType=reportType;
        this.reportDesc=reportDesc;
        this.reportStatus=reportStatus;
    }
    
    int getReportID(){return reportID;}
    String getReportType(){return reportType;}
    String getReportDesc(){return reportDesc;}
    String getReportStatus(){return reportStatus;}
    
}
