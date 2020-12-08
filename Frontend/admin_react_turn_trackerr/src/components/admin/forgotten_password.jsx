import React from "react";
import loginImg from "../../forgot_password.gif";

export class Forgotten_Password extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className="base-container" ref={this.props.containerRef}>
        <div className="header">Forgotten Password</div>
        <div className="content">
          <div className="image">
            <img src={loginImg} />
          </div>
          <div className="form">
            <div className="form-group">
              <label htmlFor="email">Email</label>
              <input type="email" name="email" placeholder="Enter Email" />
            </div>
          </div>
        </div>
        <div className="footer">
          <button type="button" className="button">
            Reset Password
          </button>
        </div>
        <label htmlFor="email">
              Check email to reset password.
        </label>
      </div>
    );
  }
}
