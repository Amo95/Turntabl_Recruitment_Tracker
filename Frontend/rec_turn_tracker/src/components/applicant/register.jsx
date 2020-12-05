import React from "react";
import loginImg from "../../signup.svg";

export class Register extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className="base-container" ref={this.props.containerRef}>
        <div className="header">Register</div>
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
            <div className="form-group">
              <label htmlFor="password">Password Confirmation</label>
              <input type="password" name="confirmPassword" placeholder="Confirm Password" required/>
            </div>
          </div>
        </div>
        <div className="footer">
          <button type="button" className="button">
            Register
          </button>
        </div>
      </div>
    );
  }
}
