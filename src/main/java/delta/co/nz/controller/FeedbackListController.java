package delta.co.nz.controller;


import delta.co.nz.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FeedbackListController {

    @Autowired
    FeedbackService feedbackService;


    @RequestMapping(value="/feedbackList", method = RequestMethod.GET)
    public ModelAndView getFeedbackList(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("feedbacks", feedbackService.getFeedbacks());
        modelAndView.setViewName("feedbackList");

        return modelAndView;
    }
}
