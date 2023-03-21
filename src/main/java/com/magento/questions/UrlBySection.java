package com.magento.questions;

import com.magento.helpers.ToRemember;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * file packagecom.magento.questions
 */
@AllArgsConstructor
public class UrlBySection implements Question<String> {

    private String section;

    public static final String SECTION_WOMEN_TEES = "tees-women";
    public static final String SECTION_MEN_TEES = "tees-men";
    public static final String SECTION_GEAR_BAGS = "gear-bags";

    public static UrlBySection value(String section){
        return new UrlBySection(section);
    }


    @Override
    public String answeredBy(Actor actor) {
        String url;
        if(section.equals(SECTION_WOMEN_TEES)){
            url = actor.recall(ToRemember.URL_WOMEN_TEES.name());
        }else if(section.equals(SECTION_MEN_TEES)){
            url = actor.recall(ToRemember.URL_MEN_TEES.name());
        }else if(section.equals(SECTION_GEAR_BAGS)){
            url = actor.recall(ToRemember.URL_GEAR_GAGS.name());
        }else {
            url=actor.recall(ToRemember.URL_BASE.name());
        }
        return url;
    }
}
