package com.limitlesscare.core.domain

interface ISuspendableUseCase {
    interface WithParams<Input, Output> {
        suspend operator fun invoke(input: Input): Output
    }

    interface WithoutParams<Output> {
        suspend operator fun invoke(): Output
    }
}