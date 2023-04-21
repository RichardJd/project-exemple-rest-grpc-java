package com.dev.richardjd.financial.adapters.in.grpc.controllers;

import com.dev.richardjd.financial.adapters.dtos.requests.FinancialRequestDto;
import com.dev.richardjd.financial.adapters.in.grpc.generatedfiles.EmptyRequest;
import com.dev.richardjd.financial.adapters.in.grpc.generatedfiles.FinancialRequest;
import com.dev.richardjd.financial.adapters.in.grpc.generatedfiles.FinancialResponse;
import com.dev.richardjd.financial.adapters.in.grpc.generatedfiles.FinancialServiceGrpc;
import com.dev.richardjd.financial.adapters.in.grpc.generatedfiles.FindAllList;
import com.dev.richardjd.financial.adapters.in.grpc.generatedfiles.FindByIdRequest;
import com.dev.richardjd.financial.application.ports.in.services.IFinancialService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.math.BigDecimal;

@RequiredArgsConstructor
@GrpcService
public class FinancialControllerGrpc extends FinancialServiceGrpc.FinancialServiceImplBase {

    private final IFinancialService financialService;

    @Override
    public void create(FinancialRequest request, StreamObserver<FinancialResponse> responseObserver) {
        FinancialRequestDto financialRequestDto = new FinancialRequestDto(
                request.getDescription(),
                request.getMonth(),
                request.getYear(),
                request.getCashFlowType(),
                BigDecimal.valueOf(request.getAmount())
        );

        Integer result = this.financialService.create(financialRequestDto);

        FinancialResponse response = FinancialResponse
                .newBuilder()
                .setId(result)
                .setDescription("Deu bom =)")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void findById(FindByIdRequest request, StreamObserver<FinancialResponse> responseObserver) {
        super.findById(request, responseObserver);
    }

    @Override
    public void deleteById(FindByIdRequest request, StreamObserver<FinancialResponse> responseObserver) {
        super.deleteById(request, responseObserver);
    }

    @Override
    public void findAll(EmptyRequest request, StreamObserver<FindAllList> responseObserver) {
        super.findAll(request, responseObserver);
    }
}
