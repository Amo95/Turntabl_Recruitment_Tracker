import React, { Component } from 'react';
import { Tabs } from 'antd';
import Tables from './recruitment-tables';
import InterviewTables from '../cards/interview-tables';
import { CalendarOutlined, ReadOutlined, PaperClipOutlined } from '@ant-design/icons';
import './tabs.css'



const { TabPane } = Tabs;



class TabContent extends Component {

    render() {
        return (
            <div className="card-container">
                <Tabs type="card" animated={true} tabBarGutter={5} >
                    <TabPane key="1" tab={
                        <div className="cont1">
                            <span className="text-light">
                                <ReadOutlined />
                        Recruitment Tracking Sheet
                     </span>
                        </div>

                    }
                    >
                        <Tables />
                        {/* <p>Content of Tab Pane 1</p>
                        <p>Content of Tab Pane 1</p>
                        <p>Content of Tab Pane 1</p> */}
                    </TabPane>
                    <TabPane tab="Interviews" key="2"
                        tab={
                            <div className="cont2">
                                <span className="text-light " >
                                    <CalendarOutlined />
                            Interviews
                        </span>
                            </div>
                        }

                    >
                        <InterviewTables />
                        {/* <p>Content of Tab Pane 2</p>
                        <p>Content of Tab Pane 2</p>
                        <p>Content of Tab Pane 2</p> */}
                    </TabPane>
                    <TabPane tab="Archived" key="3"
                        tab={
                            <div className="cont3">
                                <span className="text-dark">
                                    <PaperClipOutlined />
                                Archived
                            </span>
                            </div>
                        }
                    >
                        {/* <p>Content of Tab Pane 3</p>
                        <p>Content of Tab Pane 3</p>
                        <p>Content of Tab Pane 3</p> */}
                    </TabPane>
                </Tabs>
            </div>
        )
    }

}

export default TabContent;