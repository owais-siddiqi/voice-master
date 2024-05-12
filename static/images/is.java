<!DOCTYPE html>
<html class="wide wow-animation" lang="en">
  <head>
    <title>Home</title>
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <!-- Stylesheets-->
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Poppins:400,500,600%7CTeko:300,400,500%7CMaven+Pro:500">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://cdn.plyr.io/3.6.8/plyr.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/fonts.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>.ie-panel{display: none;background: #212121;padding: 10px 0;box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3);clear: both;text-align:center;position: relative;z-index: 1;} html.ie-10 .ie-panel, html.lt-ie-10 .ie-panel {display: block;}</style>
  </head>
  <body>
    <div class="ie-panel"><a href="http://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    
    <div class="page">
      <div id="home">
        <!-- Page Header-->
        <header class="section page-header">
          <!-- RD Navbar-->
          <div class="rd-navbar-wrap">
            <nav class="rd-navbar rd-navbar-classic" data-layout="rd-navbar-fixed" data-sm-layout="rd-navbar-fixed" data-md-layout="rd-navbar-fixed" data-md-device-layout="rd-navbar-fixed" data-lg-layout="rd-navbar-static" data-lg-device-layout="rd-navbar-fixed" data-xl-layout="rd-navbar-static" data-xl-device-layout="rd-navbar-static" data-xxl-layout="rd-navbar-static" data-xxl-device-layout="rd-navbar-static" data-lg-stick-up-offset="46px" data-xl-stick-up-offset="46px" data-xxl-stick-up-offset="46px" data-lg-stick-up="true" data-xl-stick-up="true" data-xxl-stick-up="true">
              <div class="rd-navbar-main-outer">
                <div class="rd-navbar-main">
                  <!-- RD Navbar Panel-->
                  <div class="rd-navbar-panel">
                    <!-- RD Navbar Toggle-->
                    <button class="rd-navbar-toggle" data-rd-navbar-toggle=".rd-navbar-nav-wrap"><span></span></button>
                    <!-- RD Navbar Brand-->
                    <div class="rd-navbar-brand"><a class="brand" href="index.html"><img src="images/dub.png" alt="" width="50" height="50"/></a>Voice Master</div>
                  </div>
                  <div class="rd-navbar-main-element">
                    <div class="rd-navbar-nav-wrap">
                      <!-- RD Navbar Share-->
                      <ul class="rd-navbar-nav">
                        <li class="rd-nav-item active"><a class="rd-nav-link" href="#home">Home</a></li>
                        <li class="rd-nav-item"><a class="rd-nav-link" href="#services">Services</a></li>
                        <li class="rd-nav-item"><a class="rd-nav-link" href="#contacts">Contact Us</a></li>
                      </ul>
                      <button class="login-btn navbar-login-btn" data-toggle="modal" data-target="#myModal">LOG IN</button>
                    </div>
                  </div>
                </div>
              </div>
            </nav>
          </div>
        </header>
      </div>

      <!--Home-->
      <section class="section section-sm section-first bg-default text-center" id="home" style="background-color: #ffff;">
        <div class="container" >
          <div class="row row-30 justify-content-center">
            <div class="col-sm-6" style="margin: auto;">
              <h3 class="box-icon-modern-big-title">Embrace the future of seamless speaker identification with our innovative multi-voice technology.</h3><br>
              <audio id="audio-player" controls></audio><br>
              <div class="button-container">
                  <button id="start-recording" class="record-button"><i class="fas fa-microphone"></i> Start</button>
                  <button id="pause-recording" class="record-button"><i class="fas fa-pause"></i> Pause</button>
                  <button id="stop-recording" class="record-button"><i class="fas fa-stop"></i> Stop</button>
                  <label for='input-file' class="record-button">
                     Upload
                  </label>
                  <input type="file" id="input-file" accept=".wav" style="display: none;">
                  <span id="file-name"></span>
              </div><br>
              <!--transcription box-->
              <div class="button-container">
                <div id="transcription-box"></div>
              </div>         
            </div>
            <div class="col-sm-6 text-lg-left wow fadeInUp" style="margin: auto;">
              <img src="images/t1.jpg" alt="" width="550" height=""/>
            </div>
            
          </div>
        </div>
      </section>

      <!-- See all services-->
      <section class="section section-sm section-first bg-default text-center" id="services">
        <div class="container">
          <div class="row row-30 justify-content-center">
            <div class="col-sm-6 text-lg-left wow fadeInUp" style="margin: auto;">
              <img src="images/t3.jpg" alt="" width="550" height=""/>
            </div>
            <div class="col-lg-7 col-xl-6">
              <div class="row row-30">
                <div class="col-sm-6 wow fadeInRight" data-wow-delay=".3s">
                  <article class="box-icon-modern box-icon-modern-2">
                        <div class="box-icon-modern-icon linearicons-headset"></div>
                        <h5 class="box-icon-modern-title"><a href="#">History</a></h5>
                          <div class="box-icon-modern-decor"></div>
                          <a class="button button-primary button-ujarak" id="view-history-button" href="#">View All History</a>
                  </article>
                </div>
                <div class="col-sm-6 wow fadeInRight" data-wow-delay=".1s">
                  <article class="box-icon-modern box-icon-modern-2">
                    <div class="box-icon-modern-icon linearicons-phone-in-out"></div>
                    <h5 class="box-icon-modern-title"><a href="#team">About Us</a></h5>
                    <div class="box-icon-modern-decor"></div>
                    <p class="box-icon-modern-text">Unveil the essence of our identity and purpose.</p>
                  </article>
                </div>
                <div class="col-sm-6 wow fadeInRight" data-wow-delay=".2s">
                  <article class="box-icon-modern box-icon-modern-2">
                    <div class="box-icon-modern-icon linearicons-user"></div>
                    <h5 class="box-icon-modern-title"><a href="#profile">User Profile</a></h5>
                    <div class="box-icon-modern-decor"></div>
                    <p class="box-icon-modern-text">Unlock your personalized experience.</p>
                  </article>
                </div>
                <div class="col-sm-6 wow fadeInRight" data-wow-delay=".3s">
                  <article class="box-icon-modern box-icon-modern-2">
                    <div class="box-icon-modern-icon linearicons-outbox"></div>
                    <h5 class="box-icon-modern-title"><a href="#">FAQ</a></h5>
                    <div class="box-icon-modern-decor"></div>
                    <a class="button button-primary button-ujarak" id="faq" href="#">Help and Support</a>
                  </article>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>

      <!-- Meet The Team-->
      <section class="section section-sm section-fluid bg-default" id="team">
        <div class="container-fluid">
          <h2>Meet The Team</h2>
          <div class="row row-sm row-30 justify-content-center">
            <div class="col-md-6 col-lg-5 col-xl-3 wow fadeInRight">
              <!-- Team Classic-->
              <article class="team-classic team-classic-lg"><a class="team-classic-figure" href="#"><img src="images/usman1.jpg" alt="" width="420" height="440"/></a>
                <div class="team-classic-caption">
                  <h4 class="team-classic-name"><a href="#">Usman Arif</a></h4>
                  <p class="team-classic-status">Back-End Developer</p>
                </div>
              </article>
            </div>
            <div class="col-md-6 col-lg-5 col-xl-3 wow fadeInRight" data-wow-delay=".1s">
              <!-- Team Classic-->
              <article class="team-classic team-classic-lg"><a class="team-classic-figure" href="#"><img src="images/sania1.jpg" alt="" width="420" height="424"/></a>
                <div class="team-classic-caption">
                  <h4 class="team-classic-name"><a href="#">Syeda Sania Hasan</a></h4>
                  <p class="team-classic-status">Front-End Developer</p>
                </div>
              </article>
            </div>
            <div class="col-md-6 col-lg-5 col-xl-3 wow fadeInRight" data-wow-delay=".2s">
              <!-- Team Classic-->
              <article class="team-classic team-classic-lg"><a class="team-classic-figure" href="#"><img src="images/team-13-420x424.jpg" alt="" width="420" height="424"/></a>
                <div class="team-classic-caption">
                  <h4 class="team-classic-name"><a href="#">Owais Hassan</a></h4>
                  <p class="team-classic-status">Software Developer</p>
                </div>
              </article>
            </div>
          </div>
        </div>
      </section>

      <!-- Contact information-->
      <section class="section section-sm bg-default">
        <div class="container">
          <div class="row row-30 justify-content-center">
            <div class="col-sm-8 col-md-6 col-lg-4">
              <article class="box-contacts">
                <div class="box-contacts-body">
                  <div class="box-contacts-icon fl-bigmug-line-cellphone55"></div>
                  <div class="box-contacts-decor"></div>
                  <p class="box-contacts-link"><a href="tel:#">+92 3302425784</a></p>
                </div>
              </article>
            </div>
            <div class="col-sm-8 col-md-6 col-lg-4">
              <article class="box-contacts">
                <div class="box-contacts-body">
                  <div class="box-contacts-icon fl-bigmug-line-up104"></div>
                  <div class="box-contacts-decor"></div>
                  <p class="box-contacts-link"><a href="#">Karachi Pakistan</a></p>
                </div>
              </article>
            </div>
            <div class="col-sm-8 col-md-6 col-lg-4">
              <article class="box-contacts">
                <div class="box-contacts-body">
                  <div class="box-contacts-icon fl-bigmug-line-chat55"></div>
                  <div class="box-contacts-decor"></div>
                  <p class="box-contacts-link"><a href="mailto:#">k214671@nu.edu.pk</a></p>
                  <p class="box-contacts-link"><a href="mailto:#">k213448@nu.edu.pk</a></p>
                  <p class="box-contacts-link"><a href="mailto:#">k213402@nu.edu.pk</a></p>
                </div>
              </article>
            </div>
          </div>
        </div>
      </section>

      <!-- Contact Form-->
      <section class="section section-sm section-last bg-default text-left" id="contacts">
        <div class="container">
          <article class="title-classic">
            <div class="title-classic-title">
              <h3>Get in touch</h3>
            </div>
            <div class="title-classic-text">
              <p>If you have any questions, just fill in the contact form, and we will answer you shortly.</p>
            </div>
          </article>
          <form class="rd-form rd-form-variant-2 rd-mailform" data-form-output="form-output-global" data-form-type="contact" method="post" action="bat/rd-mailform.php">
            <div class="row row-14 gutters-14">
              <div class="col-md-4">
                <div class="form-wrap">
                  <input class="form-input" id="contact-your-name-2" type="text" name="name" data-constraints="@Required">
                  <label class="form-label" for="contact-your-name-2">Your Name</label>
                </div>
              </div>
              <div class="col-md-4">
                <div class="form-wrap">
                  <input class="form-input" id="contact-email-2" type="email" name="email" data-constraints="@Email @Required">
                  <label class="form-label" for="contact-email-2">E-mail</label>
                </div>
              </div>
              <div class="col-md-4">
                <div class="form-wrap">
                  <input class="form-input" id="contact-phone-2" type="text" name="phone" data-constraints="@Numeric">
                  <label class="form-label" for="contact-phone-2">Phone</label>
                </div>
              </div>
              <div class="col-12">
                <div class="form-wrap">
                  <label class="form-label" for="contact-message-2">Message</label>
                  <textarea class="form-input textarea-lg" id="contact-message-2" name="message" data-constraints="@Required"></textarea>
                </div>
              </div>
            </div>
            <button class="button button-primary button-pipaluk" type="submit">Send Message</button>
          </form>
        </div>
      </section>
      
      <!-- Login Modal -->
      <div class="login_modal">
        <div id="myModal" class="modal fade" role="dialog">
          <div class="modal-dialog modal-lg">
            <div class="modal-content">
              <div class="modal-body">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <div class="row">
                      <div class="col-sm-6" style="background-image: url('images/dubbing.png'); display: flex; flex-direction: column; justify-content: center; align-items: center;">
                          <h2>Welcome Back</h2>
                          <p>Please log in using your personal information to stay connected with us.</p>
                      </div>
                      <div class="col-sm-6">
                          <h2 text-align: center;>Login</h2>
                          <form action="#">
                            <div class="input-field">
                                <input type="text" required>
                                <label>Email</label>
                            </div>
                            <div class="input-field">
                                <input type="password" required>
                                <label>Password</label>
                            </div>
                            <a href="#" class="forgot-pass-link">Forgot password?</a>
                            <button type="submit">Log In</button>
                         </form>
                         <div class="bottom-link">
                          Don't have an account?
                          <a href="#" id="signup-link">Signup</a>
                         </div>
                      </div>
                      </div>
                  </div>
              </div>
            </div>
          </div>

          <!-- Signup Modal -->
          <div id="signupModal" class="modal fade" role="dialog">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-body">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <div class="row">
                            <div class="col-sm-6" style="background-image: url('images/dubbing.png'); display: flex; flex-direction: column; justify-content: center; align-items: center;">
                                <h2>Welcome Back</h2>
                                <p>Sign up to create an account and get started.</p>
                            </div>
                            <div class="col-sm-6">
                                <h2 style="text-align: center;">Signup</h2>
                                <form action="#">
                                  <div class="input-field">
                                      <input type="text" required>
                                      <label>Enter your email</label>
                                  </div>
                                  <div class="input-field">
                                      <input type="password" required>
                                      <label>Create password</label>
                                  </div>
                                  <div class="policy-text">
                                    <input type="checkbox" id="policy">
                                    <label for="policy">
                                        I agree the
                                        <a href="#" class="option">Terms & Conditions</a>
                                    </label>
                                  </div>
                                  <button type="submit">Sign Up</button>
                               </form>
                               <div class="bottom-link">
                                Already have an account?
                                <a href="#" id="login-link">Login</a>
                               </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
      </div>
       
      <!--history modal-->
      <div class="modal fade" id="historyModal" tabindex="-1" role="dialog" aria-labelledby="historyModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content history-modal">
                <div class="modal-header">
                    <h4 class="modal-title col-md-9 text-center" id="historyModalLabel">History</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="margin-right: 2%;">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="saved-recordings">
                        <div class="table-responsive">
                            <table class="table table-condensed table-bordered">
                                <thead>
                                    <tr style="background-color: #007bff; color: white;">
                                        <th style="width: 15%;">Name</th>
                                        <th>Audio</th>
                                        <th style="width: 10%;">Date</th>
                                        <th style="width: 5%;">Options</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Recording 2</td>
                                        <td>
                                            <div class="custom-audio-player">
                                                <audio controls>
                                                    <source src="https://file-examples-com.github.io/uploads/2017/11/file_example_MP3_700KB.mp3" type="audio/mp3">
                                                    Your browser does not support the audio element.
                                                </audio>
                                            </div>
                                        </td>
                                        <td>December 1, 2024</td>
                                        <td>
                                            <div class="dropdown recording-options">
                                                <button class="btn btn-secondary" type="button" id="optionsMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <i class="fas fa-ellipsis-v"></i>
                                                </button>
                                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="optionsMenuButton">
                                                    <a class="dropdown-item" href="#">Delete</a>
                                                    <a class="dropdown-item" href="#">Rename</a>
                                                    <a class="dropdown-item" href="#">Download</a>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Recording 1</td>
                                        <td>
                                            <div class="custom-audio-player">
                                                <audio controls>
                                                    <source src="https://file-examples-com.github.io/uploads/2017/11/file_example_MP3_700KB.mp3" type="audio/mp3">
                                                    Your browser does not support the audio element.
                                                </audio>
                                            </div>
                                        </td>
                                        <td>October 1, 2024</td>
                                        <td>
                                            <div class="dropdown recording-options">
                                                <button class="btn btn-secondary" type="button" id="optionsMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <i class="fas fa-ellipsis-v"></i>
                                                </button>
                                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="optionsMenuButton">
                                                    <a class="dropdown-item" href="#">Delete</a>
                                                    <a class="dropdown-item" href="#">Rename</a>
                                                    <a class="dropdown-item" href="#">Download</a>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <!-- Add more saved recordings here -->
                                  </tbody>
                              </table>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
      </div>    
    
      <!--FAQ Modal-->
      <div class="modal fade" id="faqModal" tabindex="-1" role="dialog" aria-labelledby="faqModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title" id="faqModalLabel">Do You Have Questions?</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <div class="row">
                <div class="col-sm-6">
                  <img src="images/faq.jpg" alt="FAQ Image" style="max-width: 100%; height: auto;">
                </div>
                <div class="col-sm-6">
                  <p>Below you’ll find answers to the most common questions you may have on Voice Master. If you still can’t find the answer you’re looking for, just <a href="#contacts">Contact us</a>!</p>
                  <div class="box-icon-modern-decor" style="grid-column: 1 / -1;"></div>
                  <div class="faq-scroll-container" style="max-height: 300px; overflow-y: auto;">
                    <!-- FAQ Question 1 -->
                    <div class="faq-question">
                      <a href="#" class="faq-question-toggle" data-toggle="collapse" data-target="#answer1" aria-expanded="false" aria-controls="answer1">
                        1. What is the Voice Recognizer Project?
                      </a>
                      <div class="collapse" id="answer1">
                        Answer: It's a project aiming to enhance productivity and accessibility through speech transcription and speaker identification.
                      </div>
                    </div>
                    <!-- FAQ Question 2 -->
                    <div class="faq-question">
                      <a href="#" class="faq-question-toggle" data-toggle="collapse" data-target="#answer2" aria-expanded="false" aria-controls="answer2">
                        2. What are the functional requirements?
                      </a>
                      <div class="collapse" id="answer2">
                        Answer: Key features include voice identification, recording, user interface, login, saving transcriptions, and support options.
                      </div>
                    </div>
                    <!-- FAQ Question 3 -->
                    <div class="faq-question">
                      <a href="#" class="faq-question-toggle" data-toggle="collapse" data-target="#answer3" aria-expanded="false" aria-controls="answer3">
                        3. What are the non-functional requirements?
                      </a>
                      <div class="collapse" id="answer3">
                        Answer: They include performance (accuracy > 95%, response time < 1s), reliability, security, usability, and maintainability.
                      </div>
                    </div>
                    <!-- FAQ Question 4 -->
                    <div class="faq-question">
                      <a href="#" class="faq-question-toggle" data-toggle="collapse" data-target="#answer4" aria-expanded="false" aria-controls="answer4">
                        4. What are the project constraints?
                      </a>
                      <div class="collapse" id="answer4">
                        Answer: Technical dependencies, budget limitations, and user requirements for sufficient audio samples.
                      </div>
                    </div>
                    <!-- FAQ Question 5 -->
                    <div class="faq-question">
                      <a href="#" class="faq-question-toggle" data-toggle="collapse" data-target="#answer5" aria-expanded="false" aria-controls="answer5">
                        5. How does voice identification work?
                      </a>
                      <div class="collapse" id="answer5">
                        Answer: It accurately distinguishes voices and provides real-time feedback.
                      </div>
                    </div>
                    <!-- FAQ Question 6 -->
                    <div class="faq-question">
                      <a href="#" class="faq-question-toggle" data-toggle="collapse" data-target="#answer6" aria-expanded="false" aria-controls="answer6">
                        6. What support options are available?
                      </a>
                      <div class="collapse" id="answer6">
                        Answer: Users can access FAQs and contact support for assistance.
                      </div>
                    </div>
                    <!-- FAQ Question 7 -->
                    <div class="faq-question">
                      <a href="#" class="faq-question-toggle" data-toggle="collapse" data-target="#answer7" aria-expanded="false" aria-controls="answer7">
                        7. How user-friendly is the Voice Recognizer interface?
                      </a>
                      <div class="collapse" id="answer7">
                        Answer: The interface is designed to be intuitive and easy to use, catering to stakeholders with minimal technical expertise.
                      </div>
                    </div>
                    <!-- FAQ Question 8 -->
                    <div class="faq-question">
                      <a href="#" class="faq-question-toggle" data-toggle="collapse" data-target="#answer8" aria-expanded="false" aria-controls="answer8">
                        8. What measures are taken to ensure data security and privacy?
                      </a>
                      <div class="collapse" id="answer8">
                        Answer: The system prioritizes data privacy by processing audio recordings in real-time and implementing secure protocols for communication and authentication.
                      </div>
                    </div>
                    <!-- FAQ Question 9 -->
                    <div class="faq-question">
                      <a href="#" class="faq-question-toggle" data-toggle="collapse" data-target="#answer9" aria-expanded="false" aria-controls="answer9">
                        9. What is the main goal of the Voice Recognizer Project?
                      </a>
                      <div class="collapse" id="answer9">
                        Answer: The project aims to create a practical solution for speech transcription and speaker identification, enhancing productivity and accessibility.
                      </div>
                    </div>
                    <!-- FAQ Question 10 -->
                    <div class="faq-question">
                      <a href="#" class="faq-question-toggle" data-toggle="collapse" data-target="#answer10" aria-expanded="false" aria-controls="answer10">
                        10. Who are the stakeholders involved in the Voice Recognizer Project?
                      </a>
                      <div class="collapse" id="answer10">
                        Answer: The stakeholders include the development team, end-users, and project managers overseeing the progress and resource allocation.
                      </div>
                    </div>
                    <!-- FAQ Question 11 -->
                    <div class="faq-question">
                      <a href="#" class="faq-question-toggle" data-toggle="collapse" data-target="#answer11" aria-expanded="false" aria-controls="answer11">
                        11. What are the assumptions and dependencies of the Voice Recognizer Project?
                      </a>
                      <div class="collapse" id="answer11">
                        Answer: Assumptions include minimal background noise during usage and availability of high-quality audio files for model training. Dependencies include libraries like Keras, TensorFlow, and Python for implementation.
                      </div>
                    </div>
                    <!-- FAQ Question 12 -->
                    <div class="faq-question">
                      <a href="#" class="faq-question-toggle" data-toggle="collapse" data-target="#answer12" aria-expanded="false" aria-controls="answer12">
                        12. What are the key functional requirements of the Voice Recognizer Project?
                      </a>
                      <div class="collapse" id="answer12">
                        Answer: Functional requirements include accurate voice identification, real-time voice recording, intuitive user interface, secure login and registration, and options to save and retrieve transcriptions.
                      </div>
                    </div>
                    <!-- FAQ Question 13 -->
                    <div class="faq-question">
                      <a href="#" class="faq-question-toggle" data-toggle="collapse" data-target="#answer13" aria-expanded="false" aria-controls="answer13">
                        13. What are the performance goals of the Voice Recognizer Project?
                      </a>
                      <div class="collapse" id="answer13">
                        Answer: Performance goals include achieving recognition accuracy > 95% and ensuring voice identification response time within 1 second for optimal user experience.
                      </div>
                    </div>
                    <!-- FAQ Question 14 -->
                    <div class="faq-question">
                      <a href="#" class="faq-question-toggle" data-toggle="collapse" data-target="#answer14" aria-expanded="false" aria-controls="answer14">
                        14. How does the system ensure reliability and fault tolerance?
                      </a>
                      <div class="collapse" id="answer14">
                        Answer: The system ensures availability and resilience to errors, allowing smooth recovery from failures to maintain uninterrupted service.
                      </div>
                    </div>
                  </div>
                </div>
                
                
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- Page Footer-->
      <footer class="section section-fluid footer-minimal context-dark">
        <div class="bg-gray-15">
          <div class="container-fluid">
            <div class="footer-minimal-inset oh">
              <ul class="footer-list-category-2">
                <li><a href="#">UI Design</a></li>
                <li><a href="#">Windows/Mac OS Apps</a></li>
                <li><a href="#">Android/iOS Apps</a></li>
                <li><a href="#">Cloud Solutions</a></li>
                <li><a href="#">Customer Support</a></li>
              </ul>
            </div>
            <div class="footer-minimal-bottom-panel text-sm-left">
              <div class="row row-10 align-items-md-center">
                <div class="col-sm-6 col-md-4 text-sm-right text-md-center">
                  <div>
                    <ul class="list-inline list-inline-sm footer-social-list-2">
                      <li><a class="icon fa fa-facebook" href="#"></a></li>
                      <li><a class="icon fa fa-twitter" href="#"></a></li>
                      <li><a class="icon fa fa-google-plus" href="#"></a></li>
                      <li><a class="icon fa fa-instagram" href="#"></a></li>
                    </ul>
                  </div>
                </div>
                <div class="col-sm-6 col-md-4 order-sm-first">
                  <!-- Rights-->
                  <p class="rights"><span>&copy;&nbsp;</span><span class="copyright-year"></span> <span>Project</span>
                  </p>
                </div>
                <div class="col-sm-6 col-md-4 text-md-right"><span>All rights reserved.</span> <span>Design&nbsp;by&nbsp;<a href="https://www.templatemonster.com">Project</a></span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </footer>

      <div class="modal fade" id="modalCta" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h4>Contact Us</h4>
              <button class="close" type="button" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
            </div>
            <div class="modal-body">
              <form class="rd-form rd-form-variant-2 rd-mailform" data-form-output="form-output-global" data-form-type="contact-modal" method="post" action="bat/rd-mailform.php">
                <div class="row row-14 gutters-14">
                  <div class="col-12">
                    <div class="form-wrap">
                      <input class="form-input" id="contact-modal-name" type="text" name="name" data-constraints="@Required">
                      <label class="form-label" for="contact-modal-name">Your Name</label>
                    </div>
                  </div>
                  <div class="col-12">
                    <div class="form-wrap">
                      <input class="form-input" id="contact-modal-email" type="email" name="email" data-constraints="@Email @Required">
                      <label class="form-label" for="contact-modal-email">E-mail</label>
                    </div>
                  </div>
                  <div class="col-12">
                    <div class="form-wrap">
                      <input class="form-input" id="contact-modal-phone" type="text" name="phone" data-constraints="@Numeric">
                      <label class="form-label" for="contact-modal-phone">Phone</label>
                    </div>
                  </div>
                  <div class="col-12">
                    <div class="form-wrap">
                      <label class="form-label" for="contact-modal-message">Message</label>
                      <textarea class="form-input textarea-lg" id="contact-modal-message" name="message" data-constraints="@Required"></textarea>
                    </div>
                  </div>
                </div>
                <button class="button button-primary button-pipaluk" type="submit">Send Message</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div> 
    <script>
        $(document).ready(function () {
            // Open Signup Modal
            $("#signup-link").click(function () {
                $("#loginModal").modal("hide");
                $("#signupModal").modal("show");
            });

            // Open Login Modal
            $("#login-link").click(function () {
                $("#signupModal").modal("hide");
                $("#loginModal").modal("show");
            });

            // Open History Modal
            $("#view-history-button").click(function () {
                $("#historyModal").modal("hide");
                $("#historyModal").modal("show");
            });

             // Open faq Modal
             $("#faq").click(function () {
                $("#faqModal").modal("hide");
                $("#faqModal").modal("show");
            });
        });
    </script>
    <script>
      let chunks = [];
      let mediaRecorder;
      let isPaused = false;
  
      // Start recording button
      document.getElementById('start-recording').addEventListener('click', function() {
          isPaused = false; // Reset pause flag
          if (isPaused) {
              mediaRecorder.resume();
              document.getElementById('pause-recording').innerText = "Pause";
          } else {
              mediaRecorder.start();
          }
          document.getElementById('start-recording').disabled = true;
          document.getElementById('stop-recording').disabled = false;
      });
  
      // Stop recording button
      document.getElementById('stop-recording').addEventListener('click', function() {
          mediaRecorder.stop();
          document.getElementById('start-recording').disabled = false;
          document.getElementById('stop-recording').disabled = true;
          document.getElementById('pause-recording').disabled = true;
      });
  
      // Pause recording button
      document.getElementById('pause-recording').addEventListener('click', function() {
          if (!isPaused) {
              mediaRecorder.pause();
              isPaused = true;
              document.getElementById('pause-recording').innerText = "Resume";
          } else {
              mediaRecorder.resume();
              isPaused = false;
              document.getElementById('pause-recording').innerText = "Pause";
          }
      });
  
      // Media recording
      navigator.mediaDevices.getUserMedia({ audio: true })
          .then(function(stream) {
              mediaRecorder = new MediaRecorder(stream);
  
              mediaRecorder.ondataavailable = function(event) {
                  if (!isPaused) {
                      chunks.push(event.data);
                  }
              };
  
              mediaRecorder.onstop = function() {
                  let blob = new Blob(chunks, { 'type': 'audio/wav' });
                  let formData = new FormData();
                  formData.append('audio', blob, 'audio.wav');
  
                  // Send recorded audio to Flask route for processing
                  fetch('/process_audio', {
                      method: 'POST',
                      body: formData
                  })
                  .then(response => response.json())
                  .then(data => {
                      // Handle the response (predicted speaker) here
                      console.log(data);
                      // Example: Display predicted speaker in a div
                      document.getElementById('predicted-speaker').innerText = data.predicted_speaker;
                  })
                  .catch(error => {
                      console.error('Error:', error);
                  });
  
                  chunks = [];
              };
          })
          .catch(error => {
              console.error('getUserMedia error:', error);
          });
  </script>
  
        <script>
          if ('webkitSpeechRecognition' in window) {
              var recognition = new webkitSpeechRecognition();
              
              recognition.lang = 'en-US,ur-PK';
              recognition.continuous = true;
              recognition.interimResults = true;
              
              recognition.onstart = function() {
                  console.log('Speech recognition started');
              };
              
              recognition.onresult = function(event) {
                  var interimTranscript = '';
                  var finalTranscript = '';
                  
                  for (var i = event.resultIndex; i < event.results.length; ++i) {
                      if (event.results[i].isFinal) {
                          finalTranscript += event.results[i][0].transcript + ' ';
                      } else {
                          interimTranscript += event.results[i][0].transcript;
                      }
                  }
                  
                  console.log('Interim transcript: ' + interimTranscript);
                  console.log('Final transcript: ' + finalTranscript);
                  
                  // Update the transcription box with the final transcript
                  var transcriptionBox = document.getElementById('transcription-box');
                  transcriptionBox.textContent = finalTranscript;
              };
              
              recognition.onerror = function(event) {
                  console.error('Speech recognition error:', event.error);
              };
              
              recognition.onend = function(event) {
                  console.log('Speech recognition ended');
              };
              
              document.getElementById('start-recording').addEventListener('click', function() {
                  recognition.start();
              });
              
              document.getElementById('pause-recording').addEventListener('click', function() {
                  recognition.stop();
                  console.log('Speech recognition paused');
              });
              
              document.getElementById('stop-recording').addEventListener('click', function() {
                  recognition.stop();
                  console.log('Speech recognition stopped');
              });
          } else {
              console.error('Speech recognition not supported by your browser.');
          }
          </script>

    <script src="js/core.min.js"></script>
    <script src="js/script.js"></script>
    <script src="https://cdn.plyr.io/3.6.8/plyr.js"></script>
    <!-- coded by Himic-->

  </body>
</html>