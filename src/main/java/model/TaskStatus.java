package model;

public enum TaskStatus {
    TODO("TODO","A faire"),
    IN_PROGRESS("IN_PROGRESS","En cours"),
    DONE("DONE","Fait");
    private final  String code;
    private final  String label;

    TaskStatus(String code, String label){
        this.code = code;
        this.label = label;
    }
    public String getCode(){
        return this.code;
    }

    public String getLabel(){
        return this.label;
    }
}
