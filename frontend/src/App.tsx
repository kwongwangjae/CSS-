import React, { useEffect, useState } from 'react';
import AxiosInstance from './AxiosInstance';
import styled from 'styled-components';


const EmphasisText = styled.p`
  em {
    font-style: italic;
    color: red; /* 강조할 색상 지정 */
  }
`;


function App() {
  const [userInfo, setUserInfo] = useState<string | null>(null);

  useEffect(() => {
    const fetchUserInfo = async () => {
      try {
        const response = await AxiosInstance.get('/emtype');
        setUserInfo(response.data);
      } catch (error) {
        console.error('Error fetching user info', error);
      }
    };

    fetchUserInfo();
  }, []);

  return (
    <div className="App">
      <h1>User Information</h1>
      {userInfo ? (
        <EmphasisText dangerouslySetInnerHTML={{ __html: userInfo }} />
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
}

export default App;
