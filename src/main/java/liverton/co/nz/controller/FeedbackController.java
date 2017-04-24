package liverton.co.nz.controller;


import liverton.co.nz.config.EmailConfig;
import liverton.co.nz.schema.Feedback;
import liverton.co.nz.service.EmailService;
import liverton.co.nz.service.FeedbackService;
import liverton.co.nz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    ProductService productService;

    @Autowired
    EmailService emailService;

    @Autowired
    EmailConfig emailConfig;

    @RequestMapping(value="/feedback", method = RequestMethod.GET)
    public ModelAndView feedback(){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("feedback", new Feedback());
        modelAndView.addObject("productList", productService.getProducts());
        modelAndView.setViewName("feedback");

        return modelAndView;
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    public ModelAndView createFeedback(@Valid Feedback feedback, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();

        if (!bindingResult.hasErrors()) {

            try {

                feedback.setSentTo(emailConfig.emailRecipient);
                emailService.send(feedback.toString(), feedback.getCustomer().getEmail(), feedback.getSentTo());
                feedbackService.sendFeedback(feedback);

                modelAndView.addObject("successMessage", "Thanks for your feedback!");
                modelAndView.addObject("feedback", new Feedback());
                modelAndView.addObject("productList", productService.getProducts());

            } catch (Exception e) {
                //TODO: log errors
            }
        }

        modelAndView.setViewName("feedback");
        return modelAndView;
    }

    @RequestMapping(value="/feedbackList", method = RequestMethod.GET)
    public ModelAndView getFeedbacks(){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("feedbackList", feedbackService.getFeedbacks());
        modelAndView.setViewName("feedbackList");

        return modelAndView;
    }
}
