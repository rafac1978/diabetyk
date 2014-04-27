/**
 * This file is part of diabetyk-web.
 *
 * (c) 2014 SoftProject
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package pl.com.softproject.diabetyk.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Controller
public class HomeController {

    protected Logger logger = Logger.getLogger(getClass());

    @RequestMapping("/home")
    public ModelAndView home() {
        logger.debug("MyController.home()");

        return new ModelAndView("home");
    }
}
