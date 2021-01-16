//package main.api;
//
//import com.example.demo.service.model.*;
//import io.grpc.stub.StreamObserver;
//import main.service.impl.SheduleService;
//import main.service.model.Cleaner;
//import main.service.model.CleanerTime;
//import net.devh.boot.grpc.server.service.GrpcService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@GrpcService
//public class ScheduleControllerGrpc extends scheduleServiceGrpc.scheduleServiceImplBase {
//    private final SheduleService sheduleService;
//
//    @Autowired
//    public ScheduleControllerGrpc(SheduleService sheduleService){
//        this.sheduleService=sheduleService;
//    }
//
//
//    @Override
//    public void addCleanerTime(addCleanerTimeRequest request, StreamObserver<addCleanerTimeResponse> responseObserver)  {
//        try{
//            this.sheduleService.add(new CleanerTime(UUID.fromString(request.getTime().getCleaner()),
//                    new SimpleDateFormat("dd/MM/yyyy").parse(request.getTime().getDate())));
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        addCleanerTimeResponse response = addCleanerTimeResponse.newBuilder().build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    @Override
//    public void deleteCleanerTime(deleteCleanerTimeRequest request, StreamObserver<deleteCleanerTimeResponse> responseObserver) {
//        sheduleService.deleteCleanerTime(UUID.fromString(request.getId()));
//        deleteCleanerTimeResponse response = deleteCleanerTimeResponse.newBuilder().build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    @Override
//    public void getCleanerTimes(getCleanerTimesRequest request, StreamObserver<getCleanerTimesResponse> responseObserver) {
//        List<CleanerTime> cleanerTimes = sheduleService.getCleanerTimes().findAll();
//
//        List<getCleanerTimeResponse> cleanerTimeResponses = new ArrayList<>();
//        for (CleanerTime cleanerTime : cleanerTimes) {
//            getCleanerTimeResponse cleanerTimeResponse= getCleanerTimeResponse.newBuilder()
//                    .setId((cleanerTime.getId().toString()))
//                    .setDate(cleanerTime.getDate().toString())
//                    .setCleaner(cleanerTime.getCleaner().toString())
//                    .build();
//            cleanerTimeResponses.add(cleanerTimeResponse);
//        }
//        getCleanerTimesResponse response = getCleanerTimesResponse.newBuilder().addAllCleanerTime(cleanerTimeResponses).build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//}
