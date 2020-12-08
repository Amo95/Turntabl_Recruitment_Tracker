import React from "react";
import loginImg from "../../forgotPassword.png";

export class ForgotPassword extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className="banner-img-fp">
        <div className="banner-relation"></div>
          <div className="App">
            <div className="login-fp">
              <div className="container" ref={ref => (this.container = ref)}>
                
                <div className="base-container" ref={this.props.containerRef}>
                  <div className="header">Recover Password</div>
                  <div className="content">
                    <div className="image">
                      <img src={loginImg} />
                    </div>

                    <div className="form">

                      <div className="form-group">
                          <label htmlFor="email">Email</label>
                          <input type="email" name="email" placeholder="Enter Email" required/>
                      </div>

                    </div>

                  </div>

                  <div className="footer">
                    <button type="button" className="button">
                      Recover
                    </button>
                  </div>
                  <label  id = "notice"> Check Your Email After Submission </label>
                </div>
              </div>
            </div>
          </div>
        </div>
        
    );
  }
}

export default ForgotPassword;