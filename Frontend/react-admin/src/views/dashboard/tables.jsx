import { Table } from 'antd';
import { FilePdfFilled } from '@ant-design/icons';
import { Button } from 'antd'
import PacmanLoader from "react-spinners/PacmanLoader";
import { css } from "@emotion/core";




const TablesData = (props) => {

  const columns = [
    {
      title: 'First Name',
      width: 150,
      dataIndex: 'firstname',
      key: 'firstname',
      fixed: 'left',

    },
    {
      title: 'Last Name',
      width: 150,
      dataIndex: 'lastname',
      key: 'lastname',
      fixed: 'left',
    },
    {
      title: 'Application Source',
      width: 200,
      dataIndex: 'source',
      key: 'source',
      fixed: 'left',
    },
    { title: 'Known As', width: 150, dataIndex: 'knownas', key: '1' },
    { title: 'Date of Birth', width: 150, dataIndex: 'dob', key: '2' },
    {
      title: 'Gender', width: 150, dataIndex: 'gender', key: '3', filters: [
        {
          text: 'Male',
          value: 'Male',
        },
        {
          text: 'Female',
          value: 'Female',
        },
        {
          text: 'Other',
          value: 'Other',
        },
      ],
      onFilter: (value, record) => record.gender.indexOf(value) === 0,
    },
    { title: 'Street Address', width: 150, dataIndex: 'st1', key: '4' },
    { title: 'Street Address Line 2', width: 200, dataIndex: 'st2', key: '5' },
    { title: 'City/Town', width: 150, dataIndex: 'city', key: '6' },
    { title: 'State/Region', width: 150, dataIndex: 'region', key: '7' },
    { title: 'Postal/ZipCode', width: 150, dataIndex: 'postal', key: '8' },
    { title: 'Phone Number', width: 150, dataIndex: 'phonenumber', key: '9' },
    { title: 'Whatsapp Number', width: 200, dataIndex: 'whatsappnumber', key: '10' },
    { title: 'Valid Email Address', width: 200, dataIndex: 'email', key: '11' },
    { title: 'Name of University', width: 250, dataIndex: 'university', key: '12' },
    { title: 'Year of Graduation', width: 200, dataIndex: 'year_of_graduation', key: '13' },
    { title: 'NSS', width: 200, dataIndex: 'nss', key: '14' },
    { title: 'Recommended By', width: 200, dataIndex: 'recommender', key: '15' },
    { title: 'Resume', width: 150, dataIndex: 'resume', key: '16' },
    {
      title: 'Action',
      key: 'operation',
      fixed: 'right',
      width: 100,
      render: () => <button className="btn btn-danger">Delete</button>,
    },
  ];

  const override = css`
  display: block;
  margin: 0 auto;
  border-color: red;
`;


  if (props.applicantData === undefined) {
    console.log("loding......")
    return <div style={{
      width: "50%",
      margin: "0px auto"
    }}>

      <PacmanLoader
        size={30}
        css={override}
        color={"#85ddef"}
        loading={true}
      />
      <span className="text-danger">!Ooops you are offline</span>
    </div>;
  }
  const data = [];
  props.applicantData.map((d, key) => {
    data.push({
      key: key,
      firstname: d.first_name,
      lastname: d.last_name,
      knownas: d.nickname,
      dob: d.dob,
      gender: d.gender,
      year_of_graduation: d.year_of_graduation,
      university: d.university,
      st1: d.address1,
      st2: d.address2,
      city: d.city,
      region: d.region,
      phonenumber: d.phone_number,
      whatsappnumber: d.whatsApp_number,
      source: d.referral,
      postal: d.zip_code,
      recommender: d.referral,
      nss: d.nss_number != "" ? <span className="badge" style={{ backgroundColor: "lightgreen" }}>Yes</span> : <span className="badge badge-danger">No</span>,
      resume: <Button type="primary" icon={<FilePdfFilled />} >Download cv</Button>
    })
  })
  console.log(props.applicantData)

  return <Table columns={columns} dataSource={data} scroll={{ x: 1300, y: 300 }} />;

}

export default TablesData



