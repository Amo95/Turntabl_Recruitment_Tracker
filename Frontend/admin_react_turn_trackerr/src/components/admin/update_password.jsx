import React from "react";
import loginImg from "../../update_password.png";

export class Update_Password extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className="App">
      <div className="password-update">
        <div className="container" >
      <div className="base-container" ref={this.props.containerRef}>
        <div className="header">Update Password</div>
        <div className="content">
          <div className="image">
            <img src={loginImg} />
          </div>
          <div className="form">
            <div className="form-group">
                <label htmlFor="email">New Password</label>
                <input type="password" name="new password" placeholder="Enter New Password" />
            </div>
            <div className="form-group">
                <label htmlFor="email">Confirm New Password</label>
                <input type="password" name="new password" placeholder="Re-Enter New Password" />
            </div>
          </div>
        </div>
        <div className="footer">
          <button type="button" className="button">
            Update Password
          </button>
        </div>
      </div>
      </div>
      </div>
      </div>
    );
  }
}
export default Update_Password