import React from "react";
import loginImg from "../../login.jpg";

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
                <input type="email" name="email" placeholder="Enter Email" />
            </div>
            <div className="form-group">
                <label htmlFor="email">Password</label>
                <input type="password" name="password" placeholder="Enter Password" />
            </div>
          </div>
        </div>
        <div className="footer">
          <button type="button" className="button">
            Login
          </button>
        </div>
      </div>
    );
  }
}
