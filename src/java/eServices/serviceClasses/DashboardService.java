/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eServices.serviceClasses;

import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 *
 * @author 779609
 */
@Service
public class DashboardService implements Serializable{
    
    FMIService fmi=new FMIService();
    TasksService tasks=new TasksService();
    MaterialsService mat=new MaterialsService();
    LanguageService lan=new LanguageService();
    SSService sheet=new SSService();
    PendingSService pend=new PendingSService();
    
    //FMI
    private String fmiResult;
    private int fmiCount;
    private String fmiScript;
    
    //Tasks without values
    private String tasksResult;
    private int tasksCount;
    
    //Materials in Oracle 
    private String matResult;
    private int matCount;
    
    //Language
    private String lanResult;
    private String lanScript;
    private int lanCount;
    
    //SS wrong loco_Id
    private String sheetResult;
    private String sheetScript;
    private int sheetCount;
    
    //open tasks for pended SS
    private String pendResult;
    private String pendScript;
    private int pendCount;
    
    
    public void getDashboard (){
        
        fmi.checkFMI();
        fmiResult=fmi.getResult();
        fmiCount=fmi.getI();
        fmiScript=fmi.getScript();
        
        tasks.checkTasks();
        tasksResult=tasks.getResult();
        tasksCount=tasks.getI();
        
        mat.checkMaterials();
        matResult=mat.getResult();
        matCount=mat.getI();
        
        lan.checkLanguage();
        lanResult=lan.getResult();
        lanScript=lan.getScript();
        lanCount=lan.getI();
        
        sheet.checkSS();
        sheetResult=sheet.getResult();
        sheetCount=sheet.getI();
        sheetScript=sheet.getScript();
        
        pend.checkOpenTasks();
        pendResult=pend.getResult();
        pendScript=pend.getScript();
        pendCount=pend.getI();    
              
            



     }

    /**
     * @return the fmiResult
     */
    public String getFmiResult() {
        return fmiResult;
    }

    /**
     * @return the fmiCount
     */
    public int getFmiCount() {
        return fmiCount;
    }

    /**
     * @return the fmiScript
     */
    public String getFmiScript() {
        return fmiScript;
    }

    /**
     * @return the tasksResult
     */
    public String getTasksResult() {
        return tasksResult;
    }

    /**
     * @return the tasksCount
     */
    public int getTasksCount() {
        return tasksCount;
    }

    /**
     * @return the matResult
     */
    public String getMatResult() {
        return matResult;
    }

    /**
     * @return the matCount
     */
    public int getMatCount() {
        return matCount;
    }

    /**
     * @return the lanResult
     */
    public String getLanResult() {
        return lanResult;
    }

    /**
     * @return the lanScript
     */
    public String getLanScript() {
        return lanScript;
    }

    /**
     * @return the lanCount
     */
    public int getLanCount() {
        return lanCount;
    }

    /**
     * @return the sheetResult
     */
    public String getSheetResult() {
        return sheetResult;
    }

    /**
     * @return the sheetScript
     */
    public String getSheetScript() {
        return sheetScript;
    }

    /**
     * @return the sheetCount
     */
    public int getSheetCount() {
        return sheetCount;
    }

    /**
     * @return the pendResult
     */
    public String getPendResult() {
        return pendResult;
    }

    /**
     * @return the pendScript
     */
    public String getPendScript() {
        return pendScript;
    }

    /**
     * @return the pendCount
     */
    public int getPendCount() {
        return pendCount;
    }
    
}
