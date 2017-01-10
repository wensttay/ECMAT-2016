package io.github.herocode.ecmat.enums;

/**
 *
 * @version 3.1
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 08/01/2017 - 12:01:31
 */
public enum ShortCourseType{
    SHORTCOURCE("Minicurso"),
    WORKSHOP("Oficina");

    String typeName;

    private ShortCourseType(String typeName){
        this.typeName = typeName;
    }

    public String getTypeName(){
        return typeName;
    }

    public static ShortCourseType getShortCourseType(String typeName){
        for ( ShortCourseType type : ShortCourseType.values() ){
            if ( type.getTypeName().equals(typeName) ){
                return type;
            }
        }
        return null;
    }
}
