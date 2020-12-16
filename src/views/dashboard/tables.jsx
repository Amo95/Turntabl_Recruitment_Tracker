import { Table } from 'antd';
import {PushpinFilled} from '@ant-design/icons';

const formatWithIcon = (cell,row) => {
  return(
      <span><PushpinFilled/></span>
  )
}

const columns = [
    {
      title: 'First Name',
      width: 150,
      dataIndex: 'firstname',
      key: 'firstname',
      fixed: 'left', 
      formatter: formatWithIcon
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
    { title: 'Known As', width: 150, dataIndex: 'address', key: '1' },
    { title: 'Date of Birth', width: 150, dataIndex: 'address', key: '2' },
    { title: 'Gender', width: 150, dataIndex: 'address', key: '3' },
    { title: 'Street Address', width: 150, dataIndex: 'address', key: '4' },
    { title: 'Street Address Line 2', width: 200, dataIndex: 'address', key: '5' },
    { title: 'City/Town', width: 150, dataIndex: 'address', key: '6' },
    { title: 'State/Region', width: 150, dataIndex: 'address', key: '7' },
    { title: 'Postal/ZipCode', width: 150, dataIndex: 'address', key: '8' },   
    { title: 'Phone Number', width: 150, dataIndex: 'address', key: '8' },
    { title: 'Whatsapp Number', width: 200, dataIndex: 'address', key: '8' },
    { title: 'Valid Email Address', width: 200, dataIndex: 'address', key: '8' },
    { title: 'Name of University', width: 200, dataIndex: 'address', key: '8' },
    { title: 'Year of Graduation', width: 200, dataIndex: 'address', key: '8' },
    { title: 'NSS', width: 200, dataIndex: 'address', key: '8' },
    { title: 'Currently Employed', width: 250, dataIndex: 'address', key: '8' },
    { title: 'Recommended By', width: 200, dataIndex: 'address', key: '8' },
    {
    title: 'Action',
    key: 'operation',
    fixed: 'right',
    width: 100,
    render: () => <a>action</a>,
  },
];

const data = [];
for (let i = 0; i < 100; i++) {
  data.push({
    key: i,
    name: `Edrward ${i}`,
    age: 32,
    address: `London Park no. ${i}`,
  });
}
const Tables = ()=><Table columns={columns} dataSource={data} scroll={{ x: 1300, y:300 }} />;
export default Tables



