# Insurance Premium Calculation App (Microservices)

## <img alt="" src="https://img.icons8.com/external-photo3ideastudio-lineal-color-photo3ideastudio/452/external-description-museum-photo3ideastudio-lineal-color-photo3ideastudio.png" width="50" style="margin-bottom:-18px"> Description
This project count insurance for user and save results to DB.  

## <img alt="" src="https://img.icons8.com/external-flaticons-flat-flat-icons/452/external-functionality-no-code-flaticons-flat-flat-icons.png" width="50" style="margin-bottom:-15px"> Available functionality
- You can send basic info for calculation

## <img alt="" src="https://img.icons8.com/office/452/parallel-tasks.png" width="50" style="margin-bottom:-15px"> Project structure
- Microservices
- 3-Tier Architecture
- Controller
- Service
- Model
  - DTO

<img alt="" src="https://image.shutterstock.com/image-vector/get-started-icon-internet-button-600w-265614941.jpg" width="50" style="margin-bottom:-17px"> Steps required to get started
- 
- Clone repository
- Edit in resources/application.properties to your parameters
- Start 4 services: discover-server, user-service, calculate-manager-service, file-manager-service
- In Postman you should post by link: http:localhost:8081/insurance/count/1
