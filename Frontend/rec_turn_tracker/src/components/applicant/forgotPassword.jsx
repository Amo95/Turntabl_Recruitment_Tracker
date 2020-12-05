import React from "react";
import loginImg from "../../forgotPassword.png";

export class ForgotPassword extends React.Component {
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

          </div>

        </div>

        <div className="footer">
          <button type="button" className="button">
            Check E-mail after submit
          </button>
        </div>
      </div>
    );
  }
}
