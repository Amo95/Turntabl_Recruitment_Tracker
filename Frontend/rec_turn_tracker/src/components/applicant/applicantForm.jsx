import React from "react";
// import loginImg from "../../login.svg";

export class ApplicationForm extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <form>
        {/* form header */}
        <div className="App">
          <div className="form-plate-header">
            <div className="container-header" ref={ref => (this.container = ref)}>
              <div className="base-container-form-header" ref={this.props.containerRef}>
                <div className="header-form">
                  <b>TURNTABL</b> Recruitment Form
                </div> 
              </div>
            </div>
          </div>
        </div>
        
        {/* personal Information form */}
        <div className="App">
          <div className="form-plate-info">
            <div className="container" ref={ref => (this.container = ref)}>
              <div className="base-container-form" ref={this.props.containerRef}>
              <label htmlFor="email"> <b>Personal Information</b> </label>
                  <div className="content-form">
                  {/* <label htmlFor="email">Full Name || Gender</label> */}
                    <div className="form-form">
                      <div className="form-group-form-full-name">
                        <label htmlFor="First Name">First Name*</label>
                        <input className="application-form" type="text" name="firstName" placeholder="Enter First Name" required/>
                      </div>
                      <div className="form-group-form-full-name">
                        <label htmlFor="Middle Name">Middle Name</label>
                        <input className="application-form" type="text" name="middleName" placeholder="Enter Middle Name"/>
                      </div>
                    </div>
                    <div className="form-form">
                      <div className="form-group-form-full-name">
                        <label htmlFor="Last Name">Last Name*</label>
                        <input className="application-form" type="text" name="lastName" placeholder="Enter Last Name" required/>
                      </div>
                      <div className="form-group-form-full-name">
                        <label htmlFor="alias">Alias</label>
                        <input className="application-form" type="text" name="alias" placeholder="Enter Alias || Nike Name"/>
                      </div>
                    </div>
                    <div className="form-form">
                      <div className="form-group-form-full-name-date">
                        <label htmlFor="Last Name">Date of Birth*</label>
                        <input className="application-form" type="date" name="dateOfBirth" required/>
                      </div>
                      <div className="form-group-form-full-name-date">
                        <label htmlFor="Last Name">Gender*</label>
                        <select className="application-form" required>
                          <option> --Select Gender--</option>
                          <option value="Female"> Female</option>
                          <option value="Male"> Male</option>
                        </select>
                      </div>
                    </div>
                  </div> 
              </div>
            </div>
          </div>
        </div>


        <div className="App">
          <div className="form-plate-ac">
            <div className="container" ref={ref => (this.container = ref)}>
              <div className="base-container-form" ref={this.props.containerRef}>
              <label htmlFor="email"> <b>Address & Contact</b> </label>
                  <div className="content-form">

                    <div className="form-form">
                      <div className="form-group-form-ac">
                        
                        <input className="application-form" type="text" name="stretAddress" placeholder="Enter Street Address" required/>
                      </div>
                      <div className="form-group-form-ac">
                        <input className="application-form" type="text" name="streetAddress2" placeholder="Enter if Any"/>
                      </div>
                    </div>

                    <div className="form-form">
                      <div className="form-group-form-ac-min">
                        <input className="application-form" type="text" name="city" placeholder="Enter City or Town" required/>
                      </div>
                      <div className="form-group-form-ac-min">
                        <input className="application-form" type="text" name="region" placeholder="Enter State or Region" required/>
                      </div>
                      <div className="form-group-form-ac-min">
                        <input className="application-form" type="text" name="postal" placeholder="Enter Postal or Zip Code" required/>
                      </div>
                    </div>

                    <div className="form-form">
                      <div className="form-group-form-ac-min-ac">
                        <input className="application-form-ac" type="tel" name="contact" placeholder="Phone Contact" required/>
                      </div>
                      <div className="form-group-form-ac-min-ac">
                        <input className="application-form" type="tel" name="contact2" placeholder="WhatsApp Contact" />
                      </div>
                    </div>

                    <div className="form-form">
                      <div className="form-group-form-ac">
                        <input className="application-form" type="email" name="email" placeholder="Enter Email Address" required/>
                      </div>
                    </div>
                    
                  </div> 
              </div>
            </div>
          </div>
        </div>

        <div className="App">
          <div className="form-plate-es">
            <div className="container" ref={ref => (this.container = ref)}>
              <div className="base-container-form" ref={this.props.containerRef}>
              <label htmlFor="email"> <b>Employment & University</b> </label>
                  <div className="content-form">
                    <div className="form-form">
                      <div className="form-group-form-es">
                        <input className="application-form-es" type="text" name="university" placeholder="Enter University" required/>
                      </div>
                      <div className="form-group-form-es">
                        <input className="application-form-es" type="text" name="yearGraduted" placeholder="Enter Year of Graduation"/>
                      </div>
                    </div>
                    <label htmlFor="email" className="float-left"> <b>Are you doing NSS?</b> </label>
                    <div className="form-form">
                      <div className="form-group-form-es">
                        <input className="" type="radio" name="NSS_status" /> Yes
                        <input className="application-form-es" type="text" name="university" placeholder="Enter NSS Number" />
                      </div>
                      <div className="form-group-form-es">
                        <input className="" type="radio" name="NSS_status" /> No
                        <input className="application-form-es" type="text" name="yearGraduted" placeholder="Enter SSNIT Number"/>
                      </div>
                    </div>

                    <label htmlFor="email" className="float-left"> <b>Have you ever been employed?</b> </label>
                    <div className="form-form">
                      <div className="form-group-form-es">
                        <input className="" type="radio" name="jod_status" /> Yes
                        <input className="application-form-es" type="text" name="university" placeholder="Enter Company Name" />
                      </div>
                      <div className="form-group-form-es">
                        <input className="application-form-es-down" type="text" name="yearGraduted" placeholder="Enter Position Held"/>
                      </div>
                    </div>

                    <div className="form-form">
                      <div className="form-group-form-es">
                      <label htmlFor="email" className="float-left"> <b>Start Date</b> </label>
                        <input className="application-form-es" type="date" name="university"/>
                      </div>
                      <div className="form-group-form-es">
                      <label htmlFor="email" className="float-left"> <b>End Date</b> </label>
                        <input className="application-form-es" type="date" name="yearGraduted"/>
                      </div>
                    </div>

                  </div> 
              </div>
            </div>
          </div>
        </div>

        <div className="App">
          <div className="form-plate-cv">
            <div className="container" ref={ref => (this.container = ref)}>
              <div className="base-container-form" ref={this.props.containerRef}>
              <label htmlFor="email"> <b>Curriculum vitae</b> </label>
                  <div className="content-form">
                    <div className="form-form">
                      <div className="form-group-form">
                        <label htmlFor="email">Recommended By? *</label>
                        <input className="application-form" type="text" name="recommender" placeholder="Enter Email" required/>
                      </div>
                    </div>
                    <div className="form-form">
                      <div className="form-group-form">
                        <label htmlFor="email">Upload Only PDF CV *</label>
                        <input className="application-form-cv" type="file" name="cv" placeholder="Enter Email" required/>
                      </div>
                    </div>
                    <div className="footer">
                    <button type="button" className="button">
                      {/* <ApplicationForm /> */}
                      Submit Form
                    </button>
                  </div>
                  </div> 
              </div>
            </div>
          </div>
        </div>
      </form>
    );
  }
}

export default ApplicationForm;