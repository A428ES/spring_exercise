package org.launchcode.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class HelloControllers {
    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
        String html = "<form action method='POST'><input type='text' name='name' /><select name='languages'><option value='french'>French</option><option value='english'>English</option><option value='spanish'>Spanish</option><option value='chinese'>Chinese</option><option' value='arabic'>Arabic</option><option value='german'>German</option></select><input type='submit' name='submit' value='Greet me!' />";

        return html;
    }

    @RequestMapping(value = "form", method = {RequestMethod.POST})
    @ResponseBody
    public static String createMessage(@RequestParam String name, @RequestParam String languages){
        HashMap<String, String> languageMessage = new HashMap<>();
        languageMessage.put("chinese", "Nǐ hǎo");
        languageMessage.put("french", "Bonjour");
        languageMessage.put("spanish", "Hola");
        languageMessage.put("english", "Hello");
        languageMessage.put("german", "Hallo");
        languageMessage.put("arabic", "marhaban");


        return languageMessage.get(languages) + " " + name;
    }



}
