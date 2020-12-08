import React from "react";
import loginImg from "../../login.svg";
// import ApplicationForm from "./applicantForm";

export class Login extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      
      <div className="base-container" ref={this.props.containerRef}>
        <div className="header">Login</div>
        <div className="content">
          <div className="image">
            <img src={loginImg} />
          </div>
          <div className="form">
            <div className="form-group">
                <label htmlFor="email">Email</label>
                <input type="email" name="email" placeholder="Enter Email" required/>
            </div>
            <div className="form-group">
                <label htmlFor="email">Password</label>
                <input type="password" name="password" placeholder="Enter Password" required/>
            </div>
          </div>
        </div>
        <div className="footer">
          <button type="button" className="button">
            {/* <ApplicationForm /> */}
            Login
          </button>
        </div>
      </div>
    );
  }
}
