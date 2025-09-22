#!/bin/bash
set -e

BASE_DIR="src/main/java/com/example/orderservice"

# ===== ORDER =====
mkdir -p $BASE_DIR/order/{dto,entity,mapper,repository,service}
mv $BASE_DIR/dto/Order*Dto.java $BASE_DIR/order/dto/ 2>/dev/null || true
mv $BASE_DIR/entity/Order*.java $BASE_DIR/order/entity/ 2>/dev/null || true
mv $BASE_DIR/mapper/Order*Mapper.java $BASE_DIR/order/mapper/ 2>/dev/null || true
mv $BASE_DIR/repository/Order*Repository.java $BASE_DIR/order/repository/ 2>/dev/null || true

# ===== CUSTOMER =====
mkdir -p $BASE_DIR/customer/{dto,entity,mapper,repository,service}
mv $BASE_DIR/dto/Customer*Dto.java $BASE_DIR/customer/dto/ 2>/dev/null || true
mv $BASE_DIR/entity/Customer*.java $BASE_DIR/customer/entity/ 2>/dev/null || true
mv $BASE_DIR/mapper/Customer*Mapper.java $BASE_DIR/customer/mapper/ 2>/dev/null || true
mv $BASE_DIR/repository/Customer*Repository.java $BASE_DIR/customer/repository/ 2>/dev/null || true
mv $BASE_DIR/service/CustomerService.java $BASE_DIR/customer/service/ 2>/dev/null || true

# ===== DELIVERY =====
mkdir -p $BASE_DIR/delivery/{dto,entity,mapper,repository,service}
mv $BASE_DIR/dto/Delivery*Dto.java $BASE_DIR/delivery/dto/ 2>/dev/null || true
mv $BASE_DIR/dto/*Schedule*Dto.java $BASE_DIR/delivery/dto/ 2>/dev/null || true
mv $BASE_DIR/entity/Delivery*.java $BASE_DIR/delivery/entity/ 2>/dev/null || true
mv $BASE_DIR/entity/*Schedule*.java $BASE_DIR/delivery/entity/ 2>/dev/null || true
mv $BASE_DIR/mapper/Delivery*Mapper.java $BASE_DIR/delivery/mapper/ 2>/dev/null || true
mv $BASE_DIR/mapper/*Schedule*Mapper.java $BASE_DIR/delivery/mapper/ 2>/dev/null || true
mv $BASE_DIR/repository/DeliveryRepository.java $BASE_DIR/delivery/repository/ 2>/dev/null || true
mv $BASE_DIR/repository/DayScheduleRepository.java $BASE_DIR/delivery/repository/ 2>/dev/null || true

# ===== PAYMENT =====
mkdir -p $BASE_DIR/payment/{dto,entity,mapper,repository,service}
mv $BASE_DIR/dto/Payment*Dto.java $BASE_DIR/payment/dto/ 2>/dev/null || true
mv $BASE_DIR/entity/Payment*.java $BASE_DIR/payment/entity/ 2>/dev/null || true
mv $BASE_DIR/mapper/Payment*Mapper.java $BASE_DIR/payment/mapper/ 2>/dev/null || true
mv $BASE_DIR/repository/PaymentRepository.java $BASE_DIR/payment/repository/ 2>/dev/null || true

# ===== COMMON =====
mkdir -p $BASE_DIR/common/{dto,entity,mapper,repository,service,exception}
mv $BASE_DIR/dto/Api*Response.java $BASE_DIR/common/dto/ 2>/dev/null || true
mv $BASE_DIR/dto/GenericResponse*.java $BASE_DIR/common/dto/ 2>/dev/null || true
mv $BASE_DIR/exception/* $BASE_DIR/common/exception/ 2>/dev/null || true
mv $BASE_DIR/util/* $BASE_DIR/common/ 2>/dev/null || true

echo "✅ Проект успешно переложен по доменной структуре!"
