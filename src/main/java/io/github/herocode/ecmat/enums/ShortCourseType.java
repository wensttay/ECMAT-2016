/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.herocode.ecmat.enums;

/**
 *
 * @author wensttay
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
